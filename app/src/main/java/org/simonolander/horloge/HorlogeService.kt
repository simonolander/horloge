package org.simonolander.horloge

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import org.simonolander.horloge.model.Beat
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate


class HorlogeService : Service() {

    private var timer: Timer? = null

    override fun onCreate() {}

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i(TAG, "Start command flags=$flags, startId=$startId")
        startForeground()
        val beats = getBeats(intent)
        scheduleBeats(beats)
        return START_STICKY
    }

    private fun getBeats(intent: Intent): Array<Beat> {
        val beats = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayExtra(BEATS_KEY, Beat::class.java)
        } else {
            @Suppress("UNCHECKED_CAST")
            intent.getParcelableArrayExtra(BEATS_KEY) as? Array<Beat>
        } ?: throw IllegalArgumentException("Missing parcel field '$BEATS_KEY'")
        return beats
    }

    private fun startForeground() {
        val channel = createNotificationChannel()
        val notification = createNotification(channel)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
            )
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    private fun scheduleBeats(beats: Array<Beat>) {
        synchronized(this) {
            this.timer?.cancel()
            val timer = Timer()
            for (beat in beats) {
                timer.scheduleAtFixedRate(beat.delay.inWholeMilliseconds, beat.period.inWholeMilliseconds) {
                    playBeat(beat)
                }
            }
            this.timer = timer
        }
    }

    private fun createNotification(channel: NotificationChannel) =
        Notification.Builder(this, channel.id).setContentTitle("Horloge").build()

    private fun createNotificationChannel(): NotificationChannel {
        val channelName = getString(R.string.channel_name_playback)
        val channel = NotificationChannel(
            PLAYBACK_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_LOW
        ).apply { description = getString(R.string.channel_description_playback) }
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        return channel
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show()
        timer?.cancel()
    }

    private fun playBeat(beat: Beat) {
        MediaPlayer.create(this, beat.sound.resourceId).apply {
            setOnCompletionListener {
                it.reset()
                it.release()
            }
            setOnErrorListener { mp, what, extra ->
                Log.w(TAG, "Received error, exiting: mp=$mp, what=$what, extra=$extra")
                false
            }
            start()
        }
    }

    companion object {
        val TAG = HorlogeService::class.simpleName
        const val PLAYBACK_CHANNEL_ID = "horloge-playback-channel"
        const val BEATS_KEY = "beats"
        const val NOTIFICATION_ID = 1
    }
}
package org.simonolander.horloge

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.graphics.drawable.Icon
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import org.simonolander.horloge.model.Beat
import org.simonolander.horloge.model.Chime
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class HorlogeService : Service() {
    private var timer: Timer? = null

    override fun onCreate() {}

    override fun onStartCommand(
        intent: Intent,
        flags: Int,
        startId: Int,
    ): Int {
        Log.i(
            TAG,
            "Start command flags=$flags, startId=$startId",
        )
        if (intent.action == INTENT_ACTION_STOP) {
            stop()
        } else {
            val chime = getChime(intent)
            startForeground(chime)
            scheduleChime(chime)
        }
        return START_STICKY
    }

    private fun getChime(intent: Intent): Chime =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                CHIME_KEY,
                Chime::class.java,
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(CHIME_KEY)
        } ?: throw IllegalArgumentException("Missing parcel field '$CHIME_KEY'")

    private fun startForeground(chime: Chime) {
        val channel = createNotificationChannel()
        val notification =
            createNotification(
                channel,
                chime,
            )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK,
            )
        } else {
            startForeground(
                NOTIFICATION_ID,
                notification,
            )
        }
    }

    private fun scheduleChime(chime: Chime) {
        synchronized(this) {
            this.timer?.cancel()
            val timer = Timer()
            for (beat in chime.beats) {
                timer.scheduleAtFixedRate(
                    beat.delay.inWholeMilliseconds,
                    beat.period.inWholeMilliseconds,
                ) {
                    playBeat(beat.copy(volume = beat.volume * chime.volume))
                }
            }
            this.timer = timer
        }
    }

    private fun createNotification(
        channel: NotificationChannel,
        chime: Chime,
    ): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val contentIntent =
            TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(intent)
                getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            }
        val icon = Icon.createWithResource(applicationContext, android.R.drawable.ic_media_pause)
        val action =
            Notification.Action
                .Builder(
                    icon,
                    "Stop",
                    PendingIntent.getForegroundService(
                        this,
                        0,
                        createStopIntent(this),
                        PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE,
                    ),
                ).run {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        setSemanticAction(Notification.Action.SEMANTIC_ACTION_DELETE)
                    }
                    build()
                }
        return Notification
            .Builder(this, channel.id)
            .setSmallIcon(R.mipmap.ic_launcher_no_background)
            .setColor(resources.getColor(R.color.orange_horloge, null))
            .setContentTitle("Playing chime ${chime.name}")
            .setContentIntent(contentIntent)
            .addAction(action)
            .build()
    }

    private fun createNotificationChannel(): NotificationChannel {
        val channelName = getString(R.string.channel_name_playback)
        val channel =
            NotificationChannel(
                PLAYBACK_CHANNEL_ID,
                channelName,
                NotificationManager.IMPORTANCE_LOW,
            ).apply { description = getString(R.string.channel_description_playback) }
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        return channel
    }

    override fun onBind(intent: Intent): IBinder? = null

    override fun onDestroy() {
        stop()
    }

    private fun stop() {
        synchronized(this) {
            timer?.cancel()
        }
        stopSelf()
    }

    private fun playBeat(beat: Beat) {
        MediaPlayer
            .create(
                this,
                beat.sound.resourceId,
            ).apply {
                setOnCompletionListener {
                    it.reset()
                    it.release()
                }
                setOnErrorListener { mp, what, extra ->
                    Log.w(
                        TAG,
                        "Received error, exiting: mp=$mp, what=$what, extra=$extra",
                    )
                    false
                }
                setVolume(
                    beat.volume.toFloat(),
                    beat.volume.toFloat(),
                )
                start()
            }
    }

    companion object {
        private val TAG = HorlogeService::class.simpleName
        private const val PLAYBACK_CHANNEL_ID = "horloge-playback-channel"
        private const val CHIME_KEY = "chime"
        private const val NOTIFICATION_ID = 1
        private const val INTENT_ACTION_STOP = "stop"

        fun createStartIntent(
            context: Context,
            chime: Chime,
        ): Intent {
            val intent = Intent(context, HorlogeService::class.java)
            intent.putExtra(CHIME_KEY, chime)
            return intent
        }

        fun createStopIntent(context: Context): Intent {
            val intent = Intent(context, HorlogeService::class.java)
            intent.action = INTENT_ACTION_STOP
            return intent
        }
    }
}

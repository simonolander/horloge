package org.simonolander.horloge

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Process
import android.widget.Toast

class HorlogeService : Service() {

    private lateinit var handler: Handler

    override fun onCreate() {
        HandlerThread("HorlogeServiceHandlerThread", Process.THREAD_PRIORITY_AUDIO).apply {
            start()
            handler = ServiceHandler(looper)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Start service $startId", Toast.LENGTH_SHORT).show()
        handler.obtainMessage().also {
            it.arg1 = startId
            handler.sendMessage(it)
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show()
    }

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            Thread.sleep(5000)
            stopSelf(msg.arg1)
        }
    }
}
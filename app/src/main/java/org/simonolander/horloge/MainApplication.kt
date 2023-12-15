package org.simonolander.horloge

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.simonolander.horloge.config.horlogeModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(horlogeModule)
        }
    }
}
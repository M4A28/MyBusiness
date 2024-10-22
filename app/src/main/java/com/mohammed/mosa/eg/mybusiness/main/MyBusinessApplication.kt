package com.mohammed.mosa.eg.mybusiness.main

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.time4j.android.ApplicationStarter

@HiltAndroidApp
class MyBusinessApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ApplicationStarter.initialize(this, true)
    }

}
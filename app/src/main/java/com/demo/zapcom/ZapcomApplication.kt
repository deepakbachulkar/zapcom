package com.demo.zapcom

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ZapcomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
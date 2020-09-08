package com.aqua_tech.gads2020

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GadsApp : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}
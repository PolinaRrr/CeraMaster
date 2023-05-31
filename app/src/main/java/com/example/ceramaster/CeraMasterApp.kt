package com.example.ceramaster

import android.app.Application
import com.example.ceramaster.room.ClayRepository

class CeraMasterApp: Application() {
    override fun onCreate() {
        super.onCreate()
        ClayRepository.initialize(this)
    }
}
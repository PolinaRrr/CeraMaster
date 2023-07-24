package com.example.ceramaster

import android.app.Application
import com.example.ceramaster.room.ClayRepository
import com.example.ceramaster.room.GlazeRepository

class CeraMasterApp: Application() {
    override fun onCreate() {
        super.onCreate()
        ClayRepository.initialize(this)
        GlazeRepository.initialize(this)
    }
}
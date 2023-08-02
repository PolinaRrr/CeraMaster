package com.example.ceramaster

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.ceramaster.room.ClayRepository
import com.example.ceramaster.room.DatabaseMigration
import com.example.ceramaster.room.GlazeRepository
import com.example.ceramaster.room.MaterialDatabase

class CeraMasterApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
        dbInitialize()
    }

    companion object {
        private var db: MaterialDatabase? = null
        private var appContext: CeraMasterApp? = null

        fun dbInitialize() {
            db = Room.databaseBuilder(
                appContext!!, MaterialDatabase::class.java, "material"
            )
                .addMigrations(DatabaseMigration().MIGRATION_1_2)
                .build()
            ClayRepository.initialize(db!!)
            GlazeRepository.initialize(appContext as Context)
        }
    }
}
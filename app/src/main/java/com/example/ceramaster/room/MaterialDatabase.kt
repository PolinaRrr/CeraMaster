package com.example.ceramaster.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ClayDto::class], version = 1)
//@TypeConverters(ClayTypeConverters::class)
abstract class MaterialDatabase : RoomDatabase() {
    abstract fun clayDao(): ClayDao
}
package com.example.ceramaster.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.concurrent.Executors


private const val DATABASE_NAME = "material-database"

class GlazeRepository private constructor(context: Context) {
    private val database: MaterialDatabase = Room.databaseBuilder(
        context.applicationContext,
        MaterialDatabase::class.java,
        DATABASE_NAME
    ).addMigrations(DatabaseMigration().MIGRATION_1_2)
        .build()

    private val glazeDao = database.glazeDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getGlazes(): LiveData<List<GlazeDto>> = glazeDao.getLocalGlazes()

    fun getGlaze(id: Int): LiveData<GlazeDto?> = glazeDao.getGlaze(id)

    fun addGlaze(glazeDto: GlazeDto) = executor.execute{
        glazeDao.addGlaze(glazeDto)
    }

    fun updateGlaze(glazeDto: GlazeDto) = executor.execute{
        glazeDao.updateGlaze(glazeDto)
    }


    companion object {
        private var INSTANCE: GlazeRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = GlazeRepository(context)
            }
        }

        fun get(): GlazeRepository {
            return INSTANCE ?: throw IllegalStateException("GlazeRepo must be init")
        }
    }


}
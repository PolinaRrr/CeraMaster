package com.example.ceramaster.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.concurrent.Executors
import com.example.ceramaster.CeraMasterApp


private const val DATABASE_NAME = "material-database"
//вынести инициализацию базы в апп приложения убрать миграху из репозиториев

class GlazeRepository private constructor(database: MaterialDatabase) {

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
        fun initialize(database: MaterialDatabase) {
            if (INSTANCE == null) {
                INSTANCE = GlazeRepository(database)
            }
        }

        fun get(): GlazeRepository {
            return INSTANCE ?: throw IllegalStateException("GlazeRepo must be init")
        }
    }


}
package com.example.ceramaster.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.concurrent.Executors

private const val DATABASE_NAME = "material-database"

class ClayRepository private constructor(database: MaterialDatabase) {
    private val clayDao = database.clayDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getClays(): LiveData<List<ClayDto>> = clayDao.getLocalClays()

    fun getClay(id: Int): LiveData<ClayDto?> = clayDao.getClay(id)

    fun addClay(clayDto: ClayDto) = executor.execute{
        clayDao.addClay(clayDto)
    }

    fun updateClay(clayDto: ClayDto) = executor.execute{
        clayDao.updateClay(clayDto)
    }


    companion object {
        private var INSTANCE: ClayRepository? = null
        fun initialize(database: MaterialDatabase) {
            if (INSTANCE == null) {
                INSTANCE = ClayRepository(database)
            }
        }

        fun get(): ClayRepository {
            return INSTANCE ?: throw IllegalStateException("ClayRepo must be init")
        }
    }


}
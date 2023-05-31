package com.example.ceramaster.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors
import com.example.ceramaster.clay.ClayInfo

private const val DATABASE_NAME = "material-database"

class ClayRepository private constructor(context: Context) {
    private val database: MaterialDatabase = Room.databaseBuilder(
        context.applicationContext,
        MaterialDatabase::class.java,
        DATABASE_NAME
    ).build()

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
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ClayRepository(context)
            }
        }

        fun get(): ClayRepository {
            return INSTANCE ?: throw IllegalStateException("ClayRepo must be init")
        }
    }


}
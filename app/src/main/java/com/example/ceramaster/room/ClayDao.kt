package com.example.ceramaster.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.*

@Dao
interface ClayDao {
    @Query("SELECT * FROM clays  WHERE isCommon = false")
    fun getLocalClays(): LiveData<List<ClayDto>>

    @Query("SELECT * FROM clays WHERE id=:id")
    fun getClay(id: Int): LiveData<ClayDto?>

    @Update
    fun updateClay(clayDto: ClayDto)

    @Insert
    fun addClay(clayDto: ClayDto)
}
package com.example.ceramaster.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.*

@Dao
interface GlazeDao {
    @Query("SELECT * FROM glazes  WHERE isCommon = false")
    fun getLocalGlazes(): LiveData<List<GlazeDto>>

    @Query("SELECT * FROM glazes WHERE id=:id")
    fun getGlaze(id: Int): LiveData<GlazeDto?>

    @Update
    fun updateGlaze(glazeDto: GlazeDto)

    @Insert
    fun addGlaze(glazeDto: GlazeDto)
}
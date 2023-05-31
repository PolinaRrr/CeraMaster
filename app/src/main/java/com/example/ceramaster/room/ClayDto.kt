package com.example.ceramaster.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*


@Entity(tableName = "clays")
@Parcelize
data class ClayDto(
    @PrimaryKey (autoGenerate = true)
    val id: Int? = null,
    val isCommon: Boolean,
    val nameClay: String,
    val article: String? = null,
    val countryOriginal: String? = null,
    val manufacturer: String? = null,
    val minTemp: Int? = null,
    val maxTemp: Int,
    val CTE: Double,
    val waterAbsorption: Double? = null,
    val color: String,
    val massStock: Double
) : Parcelable


package com.example.ceramaster.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*


@Entity(tableName = "glazes")
@Parcelize
data class GlazeDto(
    @PrimaryKey (autoGenerate = true)
    val id: Int? = null,
    val isCommon: Boolean,
    val nameGlaze: String,
    val article: String? = null,
    val countryOriginal: String? = null,
    val manufacturer: String? = null,
    val minTemp: Int? = null,
    val maxTemp: Int,
    val CTE: Double? = null,
    val effect: String? = null,
    val color: String? = null,
    val massStock: Double
) : Parcelable


package com.example.ceramaster.glaze

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize

data class GlazeInfo(
    val id: Int? = null,
    val nameGlaze: String,
    val CTE: Double? = null,
    val maxTemperature: Int,
    val effectGlaze: String? = null,
    val colorGlaze: String? = null,
    val massStock: Double
) : Parcelable, Serializable


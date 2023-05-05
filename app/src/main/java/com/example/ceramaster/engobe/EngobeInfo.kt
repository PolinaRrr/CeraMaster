package com.example.ceramaster.engobe

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class EngobeInfo(
    val nameEngobe: String,
    val maxTemperature: Int,
    val colorEngobe: String,
    val massStock: Double
) : Parcelable, Serializable

val baseEngobes = listOf(
    EngobeInfo("Ангоб S-0620-53", 1250, "бирюзовый", 1.5),
    EngobeInfo("Ангоб S-0620-54", 1250, "светло-желтый", 1.0),
    EngobeInfo("Ангоб S-0620-60", 1200, "зеленый", 0.5),
    EngobeInfo("Ангоб S-0620-66", 1250, "алый", 0.5)
)
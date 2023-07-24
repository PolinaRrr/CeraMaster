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

//val baseGlazes = listOf(
//    GlazeInfo("Сумерки в Мытищах GG-507", 7.1, 1230, "Флоат", 1.5),
//    GlazeInfo("Медь-перемедь GG-430", 9.1, 1230, "Матовая зеленая", 1.0),
//    GlazeInfo("Под Кусто GG-502", 6.9, 1230, "Синий флоат", 0.5),
//    GlazeInfo("Прозрачная S-0120", 7.6, 1100, "Белая", 0.5)
//)
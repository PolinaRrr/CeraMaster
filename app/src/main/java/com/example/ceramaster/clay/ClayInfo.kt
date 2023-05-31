package com.example.ceramaster.clay

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize

data class ClayInfo(

    val id:Int? = null,
    val nameClay: String,
    val CTE: Double,
    val maxTemperature: Int,
    val colorClay: String,
    val massStock: Double
) : Parcelable, Serializable

val baseClays = listOf(
    ClayInfo(null,"Брауни", 5.6, 1180, "Красная", 9.5),
    ClayInfo(null,"Чайка", 6.1, 1250, "Белая", 10.0),
    ClayInfo(null,"Чугун", 7.2, 1230, "Черный", 2.5),
    ClayInfo(null,"Монтеса PM101/8", 7.1, 1050, "Белая", 12.5)
)
package com.example.ceramaster.clay

data class ClayInfo (
    val nameClay:String,
    val CTE:Double,
    val maxTemperature:Int,
    val colorClay:String,
    val massStock:Double
    )

val baseClays = listOf(
ClayInfo("Брауни",5.6,1180,"Красная",9.5),
ClayInfo("Чайка",6.1,1250,"Белая",10.0),
ClayInfo("Чугун",7.2,1230,"Черный",2.5),
ClayInfo("Монтеса PM101/8",7.1,1050,"Белая",12.5)
)
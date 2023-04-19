package com.example.ceramaster.pigment

data class PigmentInfo(
    val namePigment: String,
    val maxTemperature: Int,
    val colorPigment: String,
    val massStock: Int
)

val basePigments = listOf(
    PigmentInfo("Пигмент JY-0091А Черный", 1260, "бирюзовый", 30),
    PigmentInfo("Пигмент JY-0336 Салатовый",  1400, "светло-желтый", 100),
    PigmentInfo("Пигмент JY-2611 Желтый", 1400, "зеленый", 35),
    PigmentInfo("Пигмент JY-2875A Красный",  1250, "алый", 25)
)
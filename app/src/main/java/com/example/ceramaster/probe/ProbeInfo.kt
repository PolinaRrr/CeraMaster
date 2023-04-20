package com.example.ceramaster.probe

data class ProbeInfo(
    val nameClays: String,
    val nameGlazes: String,
    val firingTemperature: Int,
    val comment: String
)

val baseProbes = listOf(
    ProbeInfo("Витольдглина 31/1", "Глазурь GG-431 Грушино смузи", 1220, "Выдержка 20 минут"),
    ProbeInfo("Витольдглина 31/1",  "Глазурь GG-431 Грушино смузи", 1220, "Выдержка 20 минут"),
    ProbeInfo("Витольдглина Уралочка", "Глазурь GG-431 Грушино смузи",1220 , "Выдержка 20 минут"),
    ProbeInfo("Витольдглина Уралочка", "Глазурь GG-431 Грушино смузи" ,1220 , "Выдержка 20 минут")
)
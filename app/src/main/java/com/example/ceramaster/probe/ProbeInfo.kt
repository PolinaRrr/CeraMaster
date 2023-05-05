package com.example.ceramaster.probe

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ProbeInfo(
    val nameClays: String,
    val nameGlazes: String,
    val firingTemperature: Int,
    val comment: String
): Parcelable, Serializable

val baseProbes = listOf(
    ProbeInfo("Витольдглина 31/1", "Глазурь GG-431 Грушино смузи", 1220, "Выдержка 20 минут"),
    ProbeInfo("Витольдглина 31/1",  "Глазурь GG-431 Грушино смузи", 1220, "Выдержка 20 минут"),
    ProbeInfo("Витольдглина Уралочка", "Глазурь GG-431 Грушино смузи",1220 , "Выдержка 20 минут"),
    ProbeInfo("Витольдглина Уралочка", "Глазурь GG-431 Грушино смузи" ,1220 , "Выдержка 20 минут")
)
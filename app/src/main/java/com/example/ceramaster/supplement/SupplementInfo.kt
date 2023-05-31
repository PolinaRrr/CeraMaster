package com.example.ceramaster.supplement

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class SupplementInfo(
    val nameSupplement: String,
    val effectSupplement: String,
    val massStock: Int
): Parcelable, Serializable

val baseSupplements = mutableListOf(
    SupplementInfo("Каолин КР-1", "для лещадок", 3000),
    SupplementInfo("Глинозем Г-00",  "для лещадок", 2000),
    SupplementInfo("Dolapix G10", "дефлакулянт", 250),
    SupplementInfo("Воск для резерва",  "для длазуровки", 200)
)
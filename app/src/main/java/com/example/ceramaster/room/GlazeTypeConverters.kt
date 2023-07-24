package com.example.ceramaster.room

import com.example.ceramaster.validator.GlazeCardFieldsData
import java.util.*
import com.example.ceramaster.glaze.GlazeInfo

class GlazeTypeConverters {

    fun fromGlazeDtoToGlazeInfo(glaze: GlazeDto): GlazeInfo {
        return GlazeInfo(
            glaze.id,
            glaze.nameGlaze,
            glaze.CTE,
            glaze.maxTemp,
            glaze.effect,
            glaze.color,
            glaze.massStock
        )
    }

    fun fromGlazeDtoNullToGlazeInfo(glaze: GlazeDto?): GlazeInfo {
        return GlazeInfo(
            glaze?.id,
            glaze!!.nameGlaze,
            glaze.CTE,
            glaze.maxTemp,
            glaze.effect,
            glaze.color,
            glaze.massStock
        )
    }

    fun fromGlazeInfoToGlazeCardFieldsData(glaze: GlazeInfo): GlazeCardFieldsData{
        return GlazeCardFieldsData(
            glaze.nameGlaze,
            glaze.maxTemperature,
            glaze.massStock
        )
    }

    fun fromGlazeInfoToGlaze(glaze: GlazeInfo): GlazeDto {
        return GlazeDto(
            null,
            false,
            glaze.nameGlaze,
            null,
            null,
            null,
            null,
            glaze.maxTemperature,
            glaze.CTE,
            null,
            null,
            glaze.massStock
        )
    }

    fun listGlazeInfoToGlazeDto(listGlazes: List<GlazeInfo>): List<GlazeDto> {
        return listGlazes.map {
            GlazeDto(
                null,
                false,
                it.nameGlaze,
                null,
                null,
                null,
                null,
                it.maxTemperature,
                it.CTE,
                null,
                null,
                it.massStock
            )
        }
    }

    fun listGlazeDtoToGlazeInfo(listGlazes: List<GlazeDto>): List<GlazeInfo> {
        return listGlazes.map {
            GlazeInfo(
                it.id,
                it.nameGlaze,
                it.CTE,
                it.maxTemp,
                it.effect,
                it.color,
                it.massStock
            )
        }
    }

}
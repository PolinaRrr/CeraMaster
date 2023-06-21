package com.example.ceramaster.room

import com.example.ceramaster.validator.ClayCardFieldsData
import java.util.*
import com.example.ceramaster.clay.ClayInfo

class ClayTypeConverters {

    fun fromClayDtoToClayInfo(clay: ClayDto): ClayInfo {
        return ClayInfo(
            clay.id,
            clay.nameClay,
            clay.CTE,
            clay.maxTemp,
            clay.color,
            clay.massStock
        )
    }

    fun fromClayDtoNullToClayInfo(clay: ClayDto?): ClayInfo {
        return ClayInfo(
            clay?.id,
            clay!!.nameClay,
            clay.CTE,
            clay.maxTemp,
            clay.color,
            clay.massStock
        )
    }

    fun fromClayInfoToClayCardFieldsData(clay: ClayInfo): ClayCardFieldsData{
        return ClayCardFieldsData(
            clay.nameClay,
            clay.maxTemperature,
            clay.massStock
        )
    }

    fun fromClayInfoToClay(clay: ClayInfo): ClayDto {
        return ClayDto(
            null,
            false,
            clay.nameClay,
            null,
            null,
            null,
            null,
            clay.maxTemperature,
            clay.CTE,
            null,
            clay.colorClay,
            clay.massStock
        )
    }

    fun listClayInfoToClayDto(listClays: List<ClayInfo>): List<ClayDto> {
        return listClays.map {
            ClayDto(
                null,
                false,
                it.nameClay,
                null,
                null,
                null,
                null,
                it.maxTemperature,
                it.CTE,
                null,
                it.colorClay,
                it.massStock
            )
        }
    }

    fun listClayDtoToClayInfo(listClays: List<ClayDto>): List<ClayInfo> {
        return listClays.map {
            ClayInfo(
                it.id,
                it.nameClay,
                it.CTE,
                it.maxTemp,
                it.color,
                it.massStock
            )
        }
    }

}
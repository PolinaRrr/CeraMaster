package com.example.ceramaster.glaze

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.ceramaster.room.GlazeRepository
import com.example.ceramaster.room.GlazeTypeConverters
import com.example.ceramaster.room.GlazeDto
import com.example.ceramaster.validator.GlazeCardFieldsData
import com.example.ceramaster.validator.GlazeCardValidation


class GlazeCardViewModel : ViewModel() {

    private val glazeRepository = GlazeRepository.get()
    private val glazeIdLiveData = MutableLiveData<Int>()
    private val validator = GlazeCardValidation()

    var glazeLiveData: LiveData<GlazeDto?> =
        Transformations.switchMap(glazeIdLiveData) { glazeId ->
            glazeRepository.getGlaze(glazeId)
        }
    var listError = GlazeCardValidation().list


    fun validate(fieldsValues: GlazeCardFieldsData): Boolean {
        val result = validator.validate(
            mapOf(
                "nameGlaze" to (fieldsValues.nameGlaze ?: ""),
                "maxTemp" to (fieldsValues.maxTemperature?.toString() ?: ""),
                "massStock" to (fieldsValues.massInStock?.toString() ?: "")
            )
        )
        fillListErrorValidation()
        return result
    }

    private fun fillListErrorValidation() {
        listError = validator.list
        Log.d("LOGVMODEL", "${print(listError)}")
    }


    fun saveGlazeCard(glazeInfo: GlazeInfo) {

        if (glazeInfo.id != null) {
            glazeRepository.updateGlaze(GlazeTypeConverters().fromGlazeInfoToGlaze(glazeInfo))
        } else {
            glazeRepository.addGlaze(GlazeTypeConverters().fromGlazeInfoToGlaze(glazeInfo))
        }

    }
}
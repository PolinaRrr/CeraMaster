package com.example.ceramaster.validator

import android.text.Editable
import android.widget.EditText

class SettingsClayCardFields(private val fieldNameClay:EditText,private val fieldMaxTemperature:EditText,private val fieldMassInStock:EditText) {


    private fun fillValidationMapsClayCard(): Map<EditText,Map<String, Int>> {

        return mapOf(
            fieldNameClay to mapOf(
                "minLengthField" to 3,
                "maxLengthField" to 45,
            ),
            fieldMaxTemperature to mapOf(
                "minLengthField" to 3,
                "maxLengthField" to 4,
                "minValueField" to 650,
                "maxValueField" to 1350
            ),
            fieldMassInStock to mapOf(
                "minLengthField" to 1,
                "maxLengthField" to 4,
            )
         )
    }
}
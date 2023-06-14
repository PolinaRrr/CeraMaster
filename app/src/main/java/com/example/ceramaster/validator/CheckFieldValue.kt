package com.example.ceramaster.validator

import com.example.ceramaster.Validation

class CheckFieldValue (private val minValue: Int, private val maxValue: Int) : Validation {
    override fun validate(editText: String): Boolean {
        return try {
            editText.toInt() in minValue..maxValue
        } catch (e: NumberFormatException) {
            false
        }
    }
}
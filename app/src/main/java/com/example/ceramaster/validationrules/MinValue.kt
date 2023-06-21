package com.example.ceramaster.validationrules

import com.example.ceramaster.Validation

class MinValue(private val minValue: Int) : Validation {
    override fun validate(editText: String): Boolean {
        var result = false
        result = try {
            val value = editText.toInt()
            value > minValue
        } catch (e: ClassCastException) {
            false
        }
        return result
    }
}
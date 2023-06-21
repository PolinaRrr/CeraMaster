package com.example.ceramaster.validationrules

import com.example.ceramaster.Validation

class MaxValue(private val maxValue: Int) : Validation {
    override fun validate(editText: String): Boolean {
        var result = false
        result = try {
            val value = editText.toInt()
            value < maxValue
        } catch (e: ClassCastException) {
            false
        }
        return result
    }
}
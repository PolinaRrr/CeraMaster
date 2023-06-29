package com.example.ceramaster.validationrules

import com.example.ceramaster.Validation
//вот обработку каста решить
class MinValue(private val minValue: Int) : Validation {
    override fun validate(editText: String): Boolean {
        var result = false
        result = try {
            val value = editText.toInt()
            value > minValue
        } catch (e: NumberFormatException) {
            result
        }
        return result
    }
}
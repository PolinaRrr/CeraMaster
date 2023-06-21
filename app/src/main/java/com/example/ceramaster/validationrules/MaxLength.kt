package com.example.ceramaster.validationrules

import com.example.ceramaster.Validation

class MaxLength(private val maxLength: Int) : Validation {
    override fun validate(editText: String): Boolean {
        return editText.length <= maxLength
    }
}
package com.example.ceramaster.validationrules

import com.example.ceramaster.Validation

class MinLength(private val minLength: Int) : Validation {
    override fun validate(editText: String): Boolean {
        return editText.length >= minLength
    }
}
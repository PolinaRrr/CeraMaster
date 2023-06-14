package com.example.ceramaster.validator

import com.example.ceramaster.Validation


class CheckFieldLength(private val minLength: Int, private val maxLength: Int) : Validation {

    override fun validate(editText: String): Boolean {
        return editText.length >= minLength && editText.length <= maxLength
    }

}
package com.example.ceramaster

import android.widget.EditText

interface Validation {
    fun validate(editText: String): Boolean
}
package com.example.ceramaster.validator

import android.util.Log
import com.example.ceramaster.Validation


class CheckFieldLength(private val minLength: Int, private val maxLength: Int) : Validation {

    override fun validate(editText: String): Boolean {
        if (editText.length in (minLength + 1)..maxLength){
            Log.d("#####", "$editText ${editText.length}")
            return true
        }else{
            return false
        }
    }

}
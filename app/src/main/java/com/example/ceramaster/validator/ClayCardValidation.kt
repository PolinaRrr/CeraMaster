package com.example.ceramaster.validator

import android.util.Log
import com.example.ceramaster.Validator
import com.example.ceramaster.Validation
import com.example.ceramaster.validationrules.MinLength
import com.example.ceramaster.validationrules.MaxLength
import com.example.ceramaster.validationrules.MinValue
import com.example.ceramaster.validationrules.MaxValue


class ClayCardValidation : Validator {

    val list = mutableListOf<String>()

    private fun getRules(): Map<String, List<Validation>> {

        return mapOf(
            "nameClay" to listOf(
                MinLength(3),
                MaxLength(45)
            ),
            "maxTemp" to listOf(
                MinLength(3),
                MaxLength(4),
                MinValue(650),
                MaxValue(1350)
            ),
            "massStock" to listOf(
                MinLength(1),
                MaxLength(5)
            )
        )
    }

    //
    /*
    ключ - название поля, значение - ввод пользователя
    этот метод будет дергатьяс во вьюхе в методе валидации перед сохранением
     */


    override fun validate(data: Map<String, String>): Boolean {
        var result = true

        Log.d("VALIDATION_DATA", data["massStock"] ?: "fucking null")

        data.forEach { (fieldName, value) ->
            Log.d("DEBUG1", fieldName)
            val rules = getRules()[fieldName]
            rules?.forEach { rule ->
                Log.d("DEBUG2", fieldName)
                if (!rule.validate(value)) {
                    Log.d("DEBUG3", fieldName)
                    result = false
                    Log.d("LOGCCVALIDATION", fieldName)
                    list.add(fieldName)
                }
            }
        }
        return result
    }

    override fun getInvalidFields(): List<String> {
        return list
    }

}
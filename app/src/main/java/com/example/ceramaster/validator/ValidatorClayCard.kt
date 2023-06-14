package com.example.ceramaster.validator

import android.widget.EditText
import com.example.ceramaster.ValidationCard

class ValidatorClayCard(
    private val params: Map<EditText, Map<String, Int>>,
    private val valueClayCard: ClayCardValue
):ValidationCard {


    override fun validateCard(
        params: Map<EditText, Map<String, Int>>,
        valueClayCard: ClayCardValue
    ): Map<EditText, Boolean> {
        val result: Map<EditText, Boolean> = mapOf()


        return result
    }


}
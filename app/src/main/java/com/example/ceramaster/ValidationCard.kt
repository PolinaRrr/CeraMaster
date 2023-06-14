package com.example.ceramaster

import android.widget.EditText
import com.example.ceramaster.validator.ClayCardValue

interface ValidationCard {
    fun validateCard(params: Map<EditText, Map<String, Int>>,valueClayCard: ClayCardValue): Map<EditText,Boolean>
}
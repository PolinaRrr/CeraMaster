package com.example.ceramaster

import android.widget.EditText
import com.example.ceramaster.validator.ClayCardFieldsData

interface ValidationCard {
    fun validateCard(params: Map<EditText, Map<String, Int>>,valueClayCard: ClayCardFieldsData): Map<EditText,Boolean>
}
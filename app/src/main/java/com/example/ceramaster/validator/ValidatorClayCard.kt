package com.example.ceramaster.validator

import android.widget.EditText
import com.example.ceramaster.ValidationCard

class ValidatorClayCard(
    private val params: Map<EditText, Map<String, Int>>,
    private val valueClayCard: ClayCardFieldsData
) : ValidationCard {

/*
  этот метод должен пройтись по мапае и для каждого ключа провести проверку по параметрам в мапе значений с введенными значениями из объекта дто
  метод возвращает мапу, где ключ это поле, а значение - результат прохождения всех проверок на это поле, если хоть одна не пройдена, то валидация неудачная
 */
    override fun validateCard(
        params: Map<EditText, Map<String, Int>>,
        valueClayCard: ClayCardFieldsData
    ): Map<EditText, Boolean> {

    params.forEach{}

        val result: Map<EditText, Boolean> = mapOf()

        return result
    }

//
//    private fun comparisonOfValues(valueClayCard: ClayCardValue,): Boolean{
//
//    }

}
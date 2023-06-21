package com.example.ceramaster

interface Validator {
    fun validate(data: Map<String, String>): Boolean
    fun getInvalidFields():List<String>
}
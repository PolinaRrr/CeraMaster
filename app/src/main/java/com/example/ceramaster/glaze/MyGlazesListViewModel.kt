package com.example.ceramaster.glaze


import androidx.lifecycle.ViewModel
import com.example.ceramaster.room.GlazeRepository
import com.example.ceramaster.room.GlazeTypeConverters

class MyGlazesListViewModel : ViewModel() {

    private val glazeRepository = GlazeRepository.get()
    val glazesLiveData = glazeRepository.getGlazes()

    fun addGlaze(glazeInfo: GlazeInfo){
        glazeRepository.addGlaze(GlazeTypeConverters().fromGlazeInfoToGlaze(glazeInfo))
    }


}
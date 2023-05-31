package com.example.ceramaster.clay


import androidx.lifecycle.ViewModel
import com.example.ceramaster.room.ClayRepository
import com.example.ceramaster.room.ClayTypeConverters

class MyClaysListViewModel : ViewModel() {

    private val clayRepository = ClayRepository.get()
    val claysLiveData = clayRepository.getClays()

    fun addClay(clayInfo: ClayInfo){
        clayRepository.addClay(ClayTypeConverters().fromClayInfoToClay(clayInfo))
    }


}
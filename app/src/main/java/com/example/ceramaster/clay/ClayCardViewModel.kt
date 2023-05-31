package com.example.ceramaster.clay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.ceramaster.room.ClayRepository
import com.example.ceramaster.room.ClayTypeConverters
import java.util.*
import com.example.ceramaster.room.ClayDto

class ClayCardViewModel : ViewModel() {

    private val clayRepository = ClayRepository.get()
    private val clayIdLiveData = MutableLiveData<Int>()

    var clayLiveData: LiveData<ClayDto?> =
        Transformations.switchMap(clayIdLiveData) { clayId  ->
            clayRepository.getClay(clayId)
        }

    fun loadClayCard(clayId: Int){
        clayIdLiveData.value = clayId
    }
    fun saveClayCard(clayInfo: ClayInfo){
        if (clayInfo.id != null){
            clayRepository.updateClay(ClayTypeConverters().fromClayInfoToClay(clayInfo))
        } else{
            clayRepository.addClay(ClayTypeConverters().fromClayInfoToClay(clayInfo))
        }

    }
}
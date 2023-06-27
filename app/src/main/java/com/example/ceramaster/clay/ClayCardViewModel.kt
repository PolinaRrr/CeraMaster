package com.example.ceramaster.clay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.ceramaster.room.ClayRepository
import com.example.ceramaster.room.ClayTypeConverters
import com.example.ceramaster.room.ClayDto
import com.example.ceramaster.validator.ClayCardFieldsData
import com.example.ceramaster.validator.ClayCardValidation


class ClayCardViewModel : ViewModel() {

    private val clayRepository = ClayRepository.get()
    private val clayIdLiveData = MutableLiveData<Int>()

    var clayLiveData: LiveData<ClayDto?> =
        Transformations.switchMap(clayIdLiveData) { clayId ->
            clayRepository.getClay(clayId)
        }
    var listError = listOf<String>()

    fun loadClayCard(clayId: Int) {
        clayIdLiveData.value = clayId
    }

    fun validate(fieldsValues: ClayCardFieldsData): Boolean {
        return ClayCardValidation().validate(
            mapOf(
                "nameClay" to fieldsValues.nameClay.toString(),
                "maxTemp" to fieldsValues.maxTemperature.toString(),
                "massStock" to fieldsValues.massInStock.toString()
            )
        )
    }

    private fun getListErrorValidation() {
        listError = ClayCardValidation().list
    }

    private fun isSuccessValid(): Boolean{
        return true

    }

    /*
           дергается метод валидации, который передает в аргументе дто ClayCardValue
           этот метод доджен собрать мапу, где ключ - название поля, значение - ввод пользователя и передает всё это валидатору
           если валидация успешна - сохранение
           если нет - лог ошибок через вызов метода для получения этого лога
            */
    fun saveClayCard(clayInfo: ClayInfo) {

      //  if (validate(ClayTypeConverters().fromClayInfoToClayCardFieldsData(clayInfo))) {
            if (clayInfo.id != null) {
                clayRepository.updateClay(ClayTypeConverters().fromClayInfoToClay(clayInfo))
            } else {
                clayRepository.addClay(ClayTypeConverters().fromClayInfoToClay(clayInfo))
            }
//        } else {
//            getListErrorValidation()
//        }
    }
}
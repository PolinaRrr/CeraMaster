package com.example.ceramaster.engobe

//надо подумать может вынести на уровень выше и перегрузкой методов сделать
interface OnItemListClickListener {
    fun onItemClickListener(engobe: EngobeInfo)
}
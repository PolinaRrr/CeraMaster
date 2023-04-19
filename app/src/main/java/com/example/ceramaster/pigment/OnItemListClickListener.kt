package com.example.ceramaster.pigment
//надо подумать может вынести на уровень выше и перегрузкой методов сделать
interface OnItemListClickListener {
    fun onItemClickListener(pigment: PigmentInfo)
}
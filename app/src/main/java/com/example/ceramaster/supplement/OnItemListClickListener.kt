package com.example.ceramaster.supplement
//надо подумать может вынести на уровень выше и перегрузкой методов сделать
interface OnItemListClickListener {
    fun onItemClickListener(supplement: SupplementInfo)
}
package com.example.ceramaster.probe
//надо подумать может вынести на уровень выше и перегрузкой методов сделать
interface OnItemListClickListener {
    fun onItemClickListener(probe: ProbeInfo)
}
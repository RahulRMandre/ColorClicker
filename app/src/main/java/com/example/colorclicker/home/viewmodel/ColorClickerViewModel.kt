package com.example.colorclicker.home.viewmodel

import android.app.Application
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ColorClickerViewModel(application: Application):AndroidViewModel(application) {
  val numberList= MutableLiveData <ArrayList<Int>>()
  val selectedPosition= MutableLiveData(0)
  val oddColor= Color.RED
  val evenColor= Color.GREEN

  init {
      initNumberList()
  }

    private fun initNumberList() {
        val list=ArrayList<Int>()
        for(i in 1..100){
            list.add(i)
        }

        numberList.value=list
    }

    fun setSelectedNumber(position:Int){
        selectedPosition.value=position
    }
}
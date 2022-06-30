package com.example.giphyapiapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphyapiapp.model.GifData

class MainViewModel : ViewModel() {

    private val _gifDataList = MutableLiveData<List<GifData>>()
    val gifDataList: LiveData<List<GifData>>
        get() = _gifDataList

    init{
        val list = mutableListOf<GifData>()
        for(i in 1..10){
            list.add(GifData("https://i.gifer.com/2GU.gif"))
        }
        _gifDataList.value = list
    }
}
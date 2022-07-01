package com.example.giphyapiapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphyapiapp.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _gifDataList = MutableLiveData<List<String>>()
    val gifDataList: LiveData<List<String>>
        get() = _gifDataList

    init{
        viewModelScope.launch {
            _gifDataList.value = repository.getGifURLList()
        }
    }
}
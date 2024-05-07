package com.example.tea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val lastTime = MutableLiveData<String>().apply { value = null }
    val lastFood = MutableLiveData<String>().apply { value = null }
    val updateElapsedTime = MutableLiveData<Boolean>()
}

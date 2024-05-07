package com.example.count

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val count = MutableLiveData<Int>().apply { value = 0 }
}
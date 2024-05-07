package com.example.trivia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val avatarDrawable = MutableLiveData<Int>()
    val avatarText = MutableLiveData<String>()
}
package com.example.umc8th

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlbumViewModel : ViewModel() {
    private val _isMixOn = MutableLiveData<Boolean>()
    val isMixOn: LiveData<Boolean> get() = _isMixOn

    fun setMix(isOn: Boolean) {
        _isMixOn.value = isOn
    }
}
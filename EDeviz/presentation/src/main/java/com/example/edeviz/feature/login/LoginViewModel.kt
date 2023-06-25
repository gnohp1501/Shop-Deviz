package com.example.edeviz.feature.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.edeviz.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {

    private val _test = MutableLiveData<String>()
    val test: LiveData<String> get() = _test

    init {
        viewModelScope.launch {
            delay(9000)
            _test.value = "123312"
        }
    }
}
package com.example.edeviz.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.edeviz.common.NavigationCommand
import com.example.edeviz.ext.Event

open class BaseViewModel : ViewModel() {

    private val _navigationCommands = MutableLiveData<Event<NavigationCommand>>()
    val navigationCommands: LiveData<Event<NavigationCommand>> get() = _navigationCommands

    fun navigate(nav: NavigationCommand) {
        _navigationCommands.value = Event(nav)
    }

}
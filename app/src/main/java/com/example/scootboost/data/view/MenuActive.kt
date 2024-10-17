package com.example.scootboost.data.view

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel

class MenuActive: ViewModel() {
    private var _visible = mutableStateOf(false)
    val visible: State<Boolean> = _visible

    fun setValue(value: Boolean) {
        _visible.value = value
    }
}



package com.example.tp3_examen.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val _isNightMode = MutableStateFlow(false)
    val isNightMode: StateFlow<Boolean> = _isNightMode

    fun toggleNightMode() {
        Log.d("ThemeViewModel", "toggleNightMode called, current value: ${_isNightMode.value}")
        _isNightMode.update { !it }
    }
}

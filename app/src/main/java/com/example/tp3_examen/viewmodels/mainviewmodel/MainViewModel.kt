package com.example.tp3_examen.viewmodels.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay


class MainViewModel : ViewModel() {

    private val _showSplash = MutableLiveData(true)
    val showSplash: LiveData<Boolean> = _showSplash

    init {
        viewModelScope.launch {
            delay(3.seconds) // Espera 3 segundos
            _showSplash.value = false // Esto oculta la splash automáticamente en MainActivity
        }
    }

    // Método opcional si deseas hacer algo adicional después de que la splash desaparezca
    fun onSplashCompleted() {
        // Acciones adicionales, si las necesitas
    }
}

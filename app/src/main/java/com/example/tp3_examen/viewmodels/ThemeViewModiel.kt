package com.example.tp3_examen.viewmodels

import android.app.Application
import android.app.UiModeManager
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val uiModeManager: UiModeManager =
        application.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

    // Estado del modo noche usando StateFlow que sea reactivo
    private val _isNightMode = MutableStateFlow(uiModeManager.nightMode == UiModeManager.MODE_NIGHT_YES)
    val isNightMode: StateFlow<Boolean> = _isNightMode

//Método para alternar el estado del modo noche

    fun toggleNightMode() {
        viewModelScope.launch {
            val newMode = !_isNightMode.value
            _isNightMode.value = newMode

            if (newMode) {
                uiModeManager.nightMode = UiModeManager.MODE_NIGHT_YES
            } else {
                uiModeManager.nightMode = UiModeManager.MODE_NIGHT_NO
            }
        }
    }
}

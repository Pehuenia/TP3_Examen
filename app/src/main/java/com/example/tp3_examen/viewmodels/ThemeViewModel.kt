package com.example.tp3_examen.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore("app_preferences")

class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val NIGHT_MODE_KEY = booleanPreferencesKey("night_mode")

    private val _isNightMode = MutableStateFlow(false)
    val isNightMode: StateFlow<Boolean> = _isNightMode

    init {
        viewModelScope.launch {
            _isNightMode.value = loadNightMode()
        }
    }

    fun toggleNightMode() {
        _isNightMode.update { !it }
        saveNightMode(_isNightMode.value)
    }

    private suspend fun loadNightMode(): Boolean {
        val preferences = getApplication<Application>().dataStore.data.first()
        return preferences[NIGHT_MODE_KEY] ?: false
    }

    private fun saveNightMode(isNightMode: Boolean) {
        viewModelScope.launch {
            getApplication<Application>().dataStore.edit { preferences ->
                preferences[NIGHT_MODE_KEY] = isNightMode
            }
        }
    }

}














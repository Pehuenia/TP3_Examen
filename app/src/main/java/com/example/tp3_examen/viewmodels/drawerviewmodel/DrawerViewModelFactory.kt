package com.example.tp3_examen.viewmodels.drawerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DrawerViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NavDrawerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NavDrawerViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


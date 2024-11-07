package com.example.tp3_examen.viewmodels.drawerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp3_examen.data.network.AuthRetrofit
import com.example.tp3_examen.data.shared.GetUserCase


class DrawerViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NavDrawerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            val getUserService = AuthRetrofit
            val getUserCase = GetUserCase(getUserService)
            return NavDrawerViewModel(getUserCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


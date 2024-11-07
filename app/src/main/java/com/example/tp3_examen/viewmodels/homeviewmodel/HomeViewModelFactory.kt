package com.example.tp3_examen.viewmodels.homeviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp3_examen.data.shared.GetUserCase

class HomeViewModelFactory(private val getUserCase: GetUserCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(getUserCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}




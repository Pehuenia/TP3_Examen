package com.example.tp3_examen.viewmodels.transactionsviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TransactionsViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransactionsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
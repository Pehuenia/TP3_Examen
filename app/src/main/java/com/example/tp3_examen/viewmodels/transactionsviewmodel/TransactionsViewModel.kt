package com.example.tp3_examen.viewmodels.transactionsviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp3_examen.data.models.BankAccountTransaction
import com.example.tp3_examen.data.network.FirebaseConnect
import com.example.tp3_examen.data.network.services.UserRepository

import androidx.lifecycle.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

import androidx.lifecycle.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TransactionsViewModel(private val userRepository: UserRepository) : ViewModel() {

    sealed class TransactionsState {
        object Loading : TransactionsState()
        data class Success(val transactions: List<BankAccountTransaction>) : TransactionsState()
        data class Error(val exception: Throwable) : TransactionsState()
    }

    private val _transactionsState = MutableLiveData<TransactionsState>()
    val transactionsState: LiveData<TransactionsState> get() = _transactionsState

    fun loadBankAccountTransactions(userId: String) {
        _transactionsState.value = TransactionsState.Loading

        viewModelScope.launch {
            userRepository.getBankAccountTransactions(userId)
                .catch { e -> _transactionsState.value = TransactionsState.Error(e) }
                .collect { transactions -> _transactionsState.value = TransactionsState.Success(transactions) }
        }
    }
}
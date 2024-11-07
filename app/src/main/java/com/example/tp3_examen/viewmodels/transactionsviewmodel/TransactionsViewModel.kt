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
import com.example.tp3_examen.data.models.BankData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionsViewModel(private val userRepository: UserRepository) : ViewModel() {

    sealed class TransactionsState {
        object Loading : TransactionsState()
        data class Success(val bankData: BankData) : TransactionsState()
        data class Error(val exception: Throwable) : TransactionsState()
    }

    private val _transactionsState = MutableLiveData<TransactionsState>()
    val transactionsState: LiveData<TransactionsState> get() = _transactionsState


    fun loadBankData() {
        _transactionsState.value = TransactionsState.Loading
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    userRepository.loadBankData("8G75RESPB56FO7ZEhQuz")
                        .catch { e ->
                            withContext(Dispatchers.Main) {
                                _transactionsState.value = TransactionsState.Error(e)
                            }
                        }
                        .collect { bankData ->
                            withContext(Dispatchers.Main) {
                                _transactionsState.value = TransactionsState.Success(bankData)
                            }
                        }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        _transactionsState.value = TransactionsState.Error(e)
                    }
                }
            }
        }
    }

}
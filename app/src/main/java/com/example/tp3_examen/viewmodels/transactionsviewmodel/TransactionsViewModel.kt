package com.example.tp3_examen.viewmodels.transactionsviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp3_examen.data.models.BankAccountTransaction
import com.example.tp3_examen.data.network.FirebaseConnect
import com.example.tp3_examen.data.network.services.UserRepository

class TransactionsViewModel : ViewModel() {

    private val userRepository = UserRepository(FirebaseConnect.firestore)
    private val _bankAccountTransactions = MutableLiveData<List<BankAccountTransaction>>()
    val bankAccountTransactions: LiveData<List<BankAccountTransaction>> = _bankAccountTransactions

    fun loadBankAccountTransactions(userId: String) {
        userRepository.getBankAccountTransactions(
            userId,
            onSuccess = { transactions ->
                _bankAccountTransactions.value = transactions
            },
            onFailure = { exception ->
                Log.e("TransactionsViewModel", "Error al obtener transacciones", exception)
            }
        )
    }
}

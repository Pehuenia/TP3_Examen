package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModel
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModelFactory


@Composable
fun PruebasScreen(userId: String) {
    val transactionsViewModel: TransactionsViewModel = viewModel(
        factory = TransactionsViewModelFactory()
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

       // NavDrawer(themeViewModel)

        // Llama a la función para cargar las transacciones cuando el Composable se muestra por primera vez
        LaunchedEffect(userId) {
            transactionsViewModel.loadBankAccountTransactions(userId)
        }

        // Observar las transacciones desde el ViewModel
        val transactions by transactionsViewModel.bankAccountTransactions.observeAsState(emptyList())

        // Mostrar la lista de transacciones en la UI
        TransactionList(transactions = transactions)

    }

}



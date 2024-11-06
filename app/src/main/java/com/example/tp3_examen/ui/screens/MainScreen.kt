package com.example.tp3_examen.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp3_examen.components1.TransactionsList
import com.example.tp3_examen.data.network.services.UserRepository
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModel
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModelFactory

@Composable
fun MainScreen(userId: String, userRepository: UserRepository) {
    val transactionsViewModel: TransactionsViewModel = viewModel(
        factory = TransactionsViewModelFactory(userRepository)
    )




}



package com.example.tp3_examen.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp3_examen.R
import com.example.tp3_examen.components.ActionRow
import com.example.tp3_examen.components.CustomCard
import com.example.tp3_examen.components.CardBalance
import com.example.tp3_examen.components.TransactionsList
import com.example.tp3_examen.data.network.services.UserRepository
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModel
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModelFactory
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun TransactionScreen() {
    val firestore = FirebaseFirestore.getInstance()
    val userRepository = UserRepository(firestore)

    val transactionsViewModel: TransactionsViewModel = viewModel(
        factory = TransactionsViewModelFactory(userRepository)
    )

    LaunchedEffect(true) {
        transactionsViewModel.loadBankData()
    }

    val transactionsState by transactionsViewModel.transactionsState.observeAsState(
        TransactionsViewModel.TransactionsState.Loading
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 0.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.my_account),
                color = colorResource(id = R.color.black),
                fontSize = 18.sp,
                lineHeight = 21.6.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center
            )
            when (val state = transactionsState) {
                is TransactionsViewModel.TransactionsState.Loading -> {
                    LoadingScreen()
                }
                is TransactionsViewModel.TransactionsState.Error -> {
                    ErrorScreen("")
                }
                is TransactionsViewModel.TransactionsState.Success -> {
                    Log.d("bankdata", state.bankData.toString())
                    CardBalance(state.bankData.cvu, state.bankData.balance)
                }
            }

            CustomCard(height = 96) {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionRow(
                        actions = listOf(
                            stringResource(id = R.string.charge) to R.drawable.servicios_recarga_sube,
                            "EXTRAER\nDINERO" to R.drawable.servicios_extraer_dinero,
                            "TRANSFERIR\nDINERO" to R.drawable.transfer_icon
                        )
                    )
                }
            }
        }
        Column(
            modifier = Modifier.padding(0.dp),
        ) {
            when (val state = transactionsState) {
                is TransactionsViewModel.TransactionsState.Loading -> {
                    LoadingScreen()
                }
                is TransactionsViewModel.TransactionsState.Error -> {
                    ErrorScreen("")
                }
                is TransactionsViewModel.TransactionsState.Success -> {
                    TransactionsList(state.bankData.transactions)
                }
            }

        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(color = colorResource(id = R.color.purple_900))
    }
}

@Composable
fun ErrorScreen(message: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = message ?: "Error al cargar las transacciones",
            color = colorResource(id = R.color.black),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

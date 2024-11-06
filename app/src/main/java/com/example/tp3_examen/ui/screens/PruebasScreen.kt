package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModel


@Composable
fun PruebasScreen(transactionsViewModel: TransactionsViewModel) {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // NavDrawer(themeViewModel)

        // Llama a la función para cargar las transacciones cuando el Composable se muestra por primera vez

        // Observar las transacciones desde el ViewModel

        // Pantalla de prueba que muestra la lista de transacciones
       //TransactionsList(transactionsViewModel = transactionsViewModel, userId = userId)
    }
}

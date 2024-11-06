package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.TransactionItem
import com.example.tp3_examen.data.models.BankAccountTransaction
import com.example.tp3_examen.data.models.Transaction

@Composable
fun TransactionList(transactions: List<BankAccountTransaction>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        items(transactions) { transaction ->
            TransactionItem(transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: BankAccountTransaction) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "ID: ${transaction.transactionId}")
        Text(text = "Fecha: ${transaction.date}")
        Text(text = "Descripción: ${transaction.description}")
        Text(text = "Monto: ${transaction.amount} ${transaction.currency}")
        Text(text = "Tipo: ${transaction.type}")
    }
}

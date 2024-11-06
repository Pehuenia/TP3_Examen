package com.example.tp3_examen.data.models

import com.google.firebase.firestore.PropertyName

data class BankAccountTransaction(
    val amount: Int,
    val currency: String,
    val date: String,
    val description: String,
    @PropertyName("transaction_id")
    val transactionId: String,
    val type: String
)
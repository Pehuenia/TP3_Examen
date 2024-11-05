package com.example.tp3_examen.data.models

data class CreditCardTransaction(
    val amount: Double,
    val currency: String,
    val date: String,
    val description: String,
    val transaction_id: String,
    val type: String
)
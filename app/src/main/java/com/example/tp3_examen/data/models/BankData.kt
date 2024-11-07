package com.example.tp3_examen.data.models

data class BankData(
    var cvu: String = "",
    var balance: Float = 0.0f,
    var transactions: List<BankAccountTransaction> = emptyList()
)
package com.example.tp3_examen.data.models

data class BankData(
    var cvu: String = "",
    var balance: Double = 0.0,
    var transactions: List<BankAccountTransaction> = emptyList()
)
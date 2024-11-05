package com.example.tp3_examen.data.models

data class UserC(
    val balance: Double,
    val bank_account: BankAccount,
    val transactions: Transactions,
    val user_id: String
)
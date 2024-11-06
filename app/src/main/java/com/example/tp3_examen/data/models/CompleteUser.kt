package com.example.tp3_examen.data.models

data class CompleteUser(
    val balance: Double,
    val bank_account: BankAccount,
    val transaction: Transaction,  //En el Json figuraba como transactions y podía ser confuso.
    val user_id: String
)
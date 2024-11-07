package com.example.tp3_examen.data.models

data class CompleteUser(
    val balance: Float = 0.0f,
    val bank_account: BankAccount ? = null,
    val transaction: Transaction ? = null,//En el Json figuraba como transactions y podía ser confuso.
    val user_id: String = "",
)
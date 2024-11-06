package com.example.tp3_examen.data.models

data class CompleteUser(
    val balance: Double = 0.0,
    val bank_account: BankAccount ? = null,
    val transaction: Transaction ? = null,//En el Json figuraba como transactions y podía ser confuso.
    val user_id: String = "",
) {
    // Constructor sin argumentos, requerido por Firestore
    constructor() : this(transaction = null)
}
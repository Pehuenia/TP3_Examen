package com.example.tp3_examen.data.models

data class Transaction(
    val bank_account_transactions: List<BankAccountTransaction> = emptyList(),
    val credit_card_transactions: List<CreditCardTransaction> = emptyList()
)
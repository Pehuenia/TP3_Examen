package com.example.tp3_examen.data.models

data class Transactions(
    val bank_account_transactions: List<BankAccountTransaction>,
    val credit_card_transactions: List<CreditCardTransaction>
)
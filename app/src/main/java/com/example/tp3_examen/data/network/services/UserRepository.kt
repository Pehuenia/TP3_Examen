package com.example.tp3_examen.data.network.services

import android.system.Os
import android.util.Log
import com.example.tp3_examen.data.models.BankAccountTransaction
import com.example.tp3_examen.data.models.BankData
import com.example.tp3_examen.data.models.CompleteUser
import com.example.tp3_examen.data.network.FirebaseConnect.firestore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch


class UserRepository(private val firestore: FirebaseFirestore) {

    fun loadBankData(userId: String): Flow<BankData> = callbackFlow {
        val documentRef = firestore.collection("users").document(userId)

        val listener = documentRef.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                close(exception) // Si hay un error, cerramos el flujo.
                return@addSnapshotListener
            }

            launch(Dispatchers.IO) {
                if (snapshot != null && snapshot.exists()) {
                    val completeUser = snapshot.toObject(CompleteUser::class.java)

                    val bankData = BankData()
                    if (completeUser != null) {
                        bankData.cvu = completeUser.bank_account?.cvu ?: ""
                        bankData.balance = completeUser.balance
                        bankData.transactions = completeUser.transaction
                            ?.bank_account_transactions ?: emptyList()

                    }
                    trySend(bankData).isSuccess
                } else {
                    trySend(BankData())
                }
            }
        }

        awaitClose { listener.remove() }
    }


}
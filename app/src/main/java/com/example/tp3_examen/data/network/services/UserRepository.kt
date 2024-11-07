package com.example.tp3_examen.data.network.services

import android.system.Os
import android.util.Log
import com.example.tp3_examen.data.models.BankAccountTransaction
import com.example.tp3_examen.data.models.CompleteUser
import com.example.tp3_examen.data.network.FirebaseConnect.firestore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

//Para traer las transacciones bancarias de un usuario

class UserRepository(private val firestore: FirebaseFirestore) {

    fun getBankAccountTransactions(userId: String): Flow<List<BankAccountTransaction>> =
        callbackFlow {
            val documentRef = firestore.collection("users").document(userId)

            val listener = documentRef.addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    close(exception)
                    return@addSnapshotListener
                }

                launch(Dispatchers.IO) {
                    if (snapshot != null && snapshot.exists()) {
                        val bankAccountTransactions = snapshot.toObject(CompleteUser::class.java)
                            ?.transaction
                            ?.bank_account_transactions ?: emptyList()
                        trySend(bankAccountTransactions).isSuccess
                    } else {
                        trySend(emptyList()).isSuccess
                    }
                }
            }

            awaitClose { listener.remove() }
        }


}
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



    // Función para agregar un usuario
    fun addUser(
        userData: Map<String, Any>,
        onSuccess: (String) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        firestore.collection("users")
            .add(userData)
            .addOnSuccessListener { documentReference ->
                Log.d("Firestore", "Documento agregado con ID: ${documentReference.id}")
                onSuccess(documentReference.id)
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error al agregar documento", e)
                onFailure(e)
            }
    }

    // Función para leer los documentos de la colección "users"
    fun getAllUsers(
        onSuccess: (List<Map<String, Any>>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        firestore.collection("users")
            .get()
            .addOnSuccessListener { documents ->
                val usersList = documents.map { it.data }
                for (document in documents) {
                    Log.d("Firestore", "${document.id} => ${document.data}")
                }
                onSuccess(usersList)
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error al leer documentos", e)
                onFailure(e)
            }
    }
}
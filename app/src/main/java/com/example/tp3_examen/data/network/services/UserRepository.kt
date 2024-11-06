package com.example.tp3_examen.data.network.services

import android.system.Os
import android.util.Log
import com.example.tp3_examen.data.models.BankAccountTransaction
import com.example.tp3_examen.data.models.CompleteUser
import com.example.tp3_examen.data.network.FirebaseConnect.firestore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class UserRepository(private val firestore: FirebaseFirestore) {

    fun getBankAccountTransactions(userId: String): Flow<List<BankAccountTransaction>> = callbackFlow {
        val documentRef = firestore.collection("users").document(userId)
        val listener = documentRef.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                close(exception)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val bankAccountTransactions = snapshot.toObject(CompleteUser::class.java)
                    ?.transaction
                    ?.bank_account_transactions ?: emptyList()
                trySend(bankAccountTransactions).isSuccess
            } else {
                trySend(emptyList()).isSuccess
            }
        }

        awaitClose { listener.remove() }
    }
}
/*

fun getBankAccountTransactions(userId: String): Flow<List<BankAccountTransaction>> =
    callbackFlow {
        val documentRef = firestore.collection("users").document(userId)
        val listener = documentRef.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                close(exception) // Cierra el flujo en caso de error
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val bankAccountTransactions = snapshot.toObject(CompleteUser::class.java)
                    ?.transaction
                    ?.bank_account_transactions ?: emptyList()
                trySend(bankAccountTransactions).isSuccess
            } else {
                trySend(emptyList()).isSuccess // Emite lista vacía si el documento no existe
            }
        }

*/
/*
fun getBankAccountTransactions(
userId: String,
onSuccess: (List<BankAccountTransaction>) -> Unit,
onFailure: (Exception) -> Unit
) {
firestore.collection("users").document(userId).get()
.addOnSuccessListener { document ->
    if (document != null) {
        val bankAccountTransactions = document.toObject(CompleteUser::class.java)
            ?.transaction
            ?.bank_account_transactions ?: emptyList()
        onSuccess(bankAccountTransactions)
    } else {
        onSuccess(emptyList()) // En caso de que el documento esté vacío
    }
}
.addOnFailureListener { exception ->
    onFailure(exception)
}
}

*/



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
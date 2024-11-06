package com.example.tp3_examen.ui.screens

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.tp3_examen.viewmodels.userviewmodel.UserViewModel

@Composable
fun MyApp(userViewModel: UserViewModel) {
    val userData = mapOf("nombre" to "John Doe", "email" to "john.doe@example.com")

    Button(onClick = {
        userViewModel.addUser(userData,
            onSuccess = { documentId ->
                Log.d("MyApp", "Usuario agregado con ID: $documentId")
            },
            onFailure = { exception ->
                Log.w("MyApp", "Error al agregar usuario", exception)
            }
        )
    }) {
        Text("Agregar Usuario")
    }
}

package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.CustomCard
import com.example.tp3_examen.components1.ButtonApp
import com.example.tp3_examen.components1.CardService
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.LoginScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContent {
            TP3_ExamenTheme {
                LoginScreen()
                //CargarSubeScreen("Hola")
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        // Display custom card
                        CustomCard(cardNumber = "4957 7124 81544 2582")

                        // Login inputs and button
                        var usuario by remember { mutableStateOf(TextFieldValue("")) }
                        var password by remember { mutableStateOf(TextFieldValue("")) }

                        Input(
                            value = usuario,
                            onValueChange = { usuario = it },
                            label = "DNI o E-mail",
                            errorMessage = "Formato de email invalido",
                            isValid = { android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() }
                        )
                        Input(
                            value = password,
                            onValueChange = { password = it },
                            label = "Contraseña",
                            errorMessage = "La contraseña debe tener al menos 4 caracteres",
                            isValid = { it.length >= 4 },
                            keyboardType = androidx.compose.ui.text.input.KeyboardType.Password,
                            imeAction = androidx.compose.ui.text.input.ImeAction.Done,
                            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                            isPassword = true
                        )
                        ButtonApp(text = "Ingresar", {})

                        CardService(R.drawable.servicios_recarga_sube, "RECARGA SUBE", R.drawable.img)
                    }
                }
            }
        }
    }
}

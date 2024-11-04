package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.ButtonApp
import com.example.tp3_examen.components1.CardActions
import com.example.tp3_examen.components1.CardMoneyManagement
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.components1.PruebaCard
import com.example.tp3_examen.components1.TransactionsList
import com.example.tp3_examen.components1.modalCargaSube.CardSube
import com.example.tp3_examen.ui.screens.LoginScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen
import com.example.tp3_examen.ui.screens.PruebasScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TP3_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    PagoDeServiciosScreen()
                    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp)
                        ) {
/*
                            var usuario by remember { mutableStateOf(TextFieldValue("")) }
                            var password by remember { mutableStateOf(TextFieldValue("")) }

                            Input(
                                value = usuario,
                                onValueChange = { usuario = it },
                                label = "DNI o E-mail",
                                errorMessage = "Formato de email invalido",
                                isValid = {
                                    android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()
                                },
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
                            CardSube()
                            PruebaCard()
                            CardActions()

                            CardMoneyManagement()
                            TransactionsList()

                        }
                        Scaffold(modifier = Modifier.fillMaxSize()) {
                            //HomeScreen()
                            LoginScreen()
*/
                            PruebasScreen()



                            

                        }
                    }
                }
            }
        }
    }
}
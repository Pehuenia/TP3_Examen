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
import com.example.tp3_examen.ui.screens.LoginScreen
import com.example.tp3_examen.ui.screens.TransactionScreen
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.CustomCard
import com.example.tp3_examen.components1.ButtonApp
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.Splash
import com.example.tp3_examen.ui.screens.SplashScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TP3_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    //LoginScreen()
                    //CargarSubeScreen("Continuar")
                    SplashScreen()
                }
            }
        }
    }
}
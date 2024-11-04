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
import androidx.lifecycle.ViewModelProvider
import com.example.tp3_examen.components1.ButtonApp
import com.example.tp3_examen.components1.CardActions
import com.example.tp3_examen.components1.CardService
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.Splash
import com.example.tp3_examen.ui.screens.SplashScreen
import com.example.tp3_examen.components1.PruebaCard
import com.example.tp3_examen.components1.TransactionsList
import com.example.tp3_examen.data.network.AuthRetrofit
import com.example.tp3_examen.data.shared.LoginUseCase
import com.example.tp3_examen.navigation.AppNavigation
import com.example.tp3_examen.ui.screens.LoginScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme
import com.example.tp3_examen.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authService = AuthRetrofit
        val loginUseCase = LoginUseCase(authService)
        val viewModel = ViewModelProvider(this, LoginViewModel.provideFactory(loginUseCase)).get(LoginViewModel::class.java)

        setContent {
            TP3_ExamenTheme {
                val token by viewModel.token

                if (token == null) {
                    Scaffold {
                        LoginScreen(viewModel)
                    }
                } else {
                    AppNavigation()
                }
            }
        }
    }
}

package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp3_examen.data.network.AuthRetrofit
import com.example.tp3_examen.data.shared.LoginUseCase
import com.example.tp3_examen.navigation.AppNavigation
import com.example.tp3_examen.navigation.Rutas
import com.example.tp3_examen.ui.screens.LoginScreen
import com.example.tp3_examen.ui.screens.SplashScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme
import com.example.tp3_examen.viewmodels.LoginViewModel
import com.example.tp3_examen.viewmodels.mainviewmodel.MainViewModel
import com.example.tp3_examen.viewmodels.mainviewmodel.MainViewModelFactory


class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authService = AuthRetrofit
        val loginUseCase = LoginUseCase(authService)
        val viewModel = ViewModelProvider(
            this,
            LoginViewModel.provideFactory(loginUseCase)
        ).get(LoginViewModel::class.java)

        setContent {
            TP3_ExamenTheme() {
                val mainViewModel: MainViewModel = viewModel(factory = MainViewModelFactory())
                val token by viewModel.token
                val showSplash by mainViewModel.showSplash.observeAsState(true)
                if (showSplash) {
                    SplashScreen()
                    // Cuando showSplash cambia a false, navega a la pantalla principal
                    LaunchedEffect(showSplash) {
                        if (!showSplash) {
                            mainViewModel.onSplashCompleted() // Cambia el estado de la splash para ocultarla
                        }
                    }
                } else {
                    if (token == null) {
                        LoginScreen(viewModel)
                    } else {
                        AppNavigation()
                    }
                }
            }
        }
    }
}
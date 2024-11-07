package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
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
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

            TP3_ExamenTheme () {
                val token by viewModel.token



                if (token != null) {

                        ModalDrawerSheet {  }
                        LoginScreen(viewModel)

                } else {
                    AppNavigation(viewModel,drawerState)
                }





            }
        }
    }
}

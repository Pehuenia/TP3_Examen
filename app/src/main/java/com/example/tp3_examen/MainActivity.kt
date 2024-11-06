package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.lifecycle.ViewModelProvider
import com.example.tp3_examen.data.network.AuthRetrofit
import com.example.tp3_examen.data.shared.LoginUseCase
import com.example.tp3_examen.navigation.AppNavigation
import com.example.tp3_examen.ui.screens.LoginScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme
import com.example.tp3_examen.viewmodels.LoginViewModel
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.tp3_examen.data.network.FirebaseConnect
import com.example.tp3_examen.data.network.services.UserRepository
import com.example.tp3_examen.ui.screens.PruebasScreen
import com.example.tp3_examen.viewmodels.ThemeViewModel
import com.example.tp3_examen.viewmodels.ThemeViewModelFactory
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModel
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModelFactory


class MainActivity : ComponentActivity() {

    private val themeViewModel: ThemeViewModel by viewModels {
        ThemeViewModelFactory(application)
    }

    private val transactionsViewModel: TransactionsViewModel by viewModels {
        TransactionsViewModelFactory(UserRepository(FirebaseConnect.firestore))
    }


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val authService = AuthRetrofit
        val loginUseCase = LoginUseCase(authService)
        val viewModel = ViewModelProvider(this, LoginViewModel.provideFactory(loginUseCase)).get(LoginViewModel::class.java)

        setContent {
            val isNightMode by themeViewModel.isNightMode.collectAsState()
            TP3_ExamenTheme (darkTheme = isNightMode) {
                val token by viewModel.token



                if (token != null) {
                    Scaffold {
                        LoginScreen(viewModel)
                    }
                } else {
                    AppNavigation()
                }




           //  PruebasScreen(transactionsViewModel = transactionsViewModel)




            }
        }
    }
}

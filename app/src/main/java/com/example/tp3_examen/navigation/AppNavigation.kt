package com.example.tp3_examen.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.ui.screens.HomeScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(56.dp),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Rutas.HomeScreen.ruta)
                    }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = {
                        navController.navigate(Rutas.PagoDeServiciosScreen.ruta)
                    }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                },
            )
        },
    ) {
        NavHost(navController = navController, startDestination = Rutas.HomeScreen.ruta, builder = {
            composable(Rutas.HomeScreen.ruta) {
                HomeScreen()

            }
            composable(Rutas.PagoDeServiciosScreen.ruta) {
                PagoDeServiciosScreen()
            }
        }
        )
    }
}

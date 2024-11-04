package com.example.tp3_examen.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
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
import com.example.tp3_examen.ui.screens.MenuScreen
import com.example.tp3_examen.ui.screens.MyAcountyScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen
import com.example.tp3_examen.ui.screens.TransactionScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(56.dp),
                actions = {
                    IconButton(onClick = { navController.navigate(Rutas.HomeScreen.ruta) })
                    { Icon(Icons.Filled.Home, contentDescription = "Localized description") }
                    IconButton(onClick = { navController.navigate(Rutas.PagoDeServiciosScreen.ruta) })
                    { Icon(Icons.Filled.CheckCircle, contentDescription = "Localized description",) }
                    IconButton(onClick = { navController.navigate(Rutas.MenuScreen.ruta) })
                    { Icon(Icons.Filled.Build, contentDescription = "Localized description",) }
                    IconButton(onClick = { navController.navigate(Rutas.MyAcountyScreen.ruta) })
                    { Icon(Icons.Filled.AccountBox, contentDescription = "Localized description",) }
                    IconButton(onClick = { navController.navigate(Rutas.TransaccionsScreen.ruta) })
                    { Icon(Icons.Filled.Email, contentDescription = "Localized description",) }
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
            composable(Rutas.MenuScreen.ruta) {
                MenuScreen()
            }
            composable(Rutas.MyAcountyScreen.ruta) {
                MyAcountyScreen()
            }
            composable(Rutas.TransaccionsScreen.ruta) {
                TransactionScreen()
            }
        }
        )
    }
}

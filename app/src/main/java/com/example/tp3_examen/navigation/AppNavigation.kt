package com.example.tp3_examen.navigation

import android.annotation.SuppressLint
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.R
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
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.menu4),
                            description = "Home",
                            onClick = { navController.navigate(Rutas.HomeScreen.ruta) }
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.menu6),
                            description = "TransaccionsScreen",
                            onClick = { navController.navigate(Rutas.TransaccionsScreen.ruta) }
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.menu3),
                            description = "Menu",
                            onClick = { navController.navigate(Rutas.MenuScreen.ruta) }
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.menu5),
                            description = "PagoDeServiciosScreen",
                            onClick = { navController.navigate(Rutas.PagoDeServiciosScreen.ruta) }
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.menu2),
                            description = "MyAcountyScreen",
                            onClick = { navController.navigate(Rutas.MyAcountyScreen.ruta) }
                        )
                    }
                }
            )
        }
    ) {
        NavHost(navController = navController, startDestination = Rutas.HomeScreen.ruta) {
            composable(Rutas.HomeScreen.ruta) { HomeScreen() }
            composable(Rutas.TransaccionsScreen.ruta) { TransactionScreen() }
            composable(Rutas.MenuScreen.ruta) { MenuScreen() }
            composable(Rutas.PagoDeServiciosScreen.ruta) { PagoDeServiciosScreen() }
            composable(Rutas.MyAcountyScreen.ruta) { MyAcountyScreen() }

        }
    }
}

@Composable
fun BottomBarIcon(
    painter: Painter,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painter,
            contentDescription = description,
            modifier = Modifier.size(50.dp)
        )
    }
}

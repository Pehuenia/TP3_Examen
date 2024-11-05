package com.example.tp3_examen.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.R
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.HomeScreen
import com.example.tp3_examen.ui.screens.MyAcountyScreen
import com.example.tp3_examen.ui.screens.MycardScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen
import com.example.tp3_examen.ui.screens.TransactionScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(Rutas.HomeScreen.ruta) } // Estado para el ítem seleccionado


    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if(currentRoute != Rutas.CargarSubeScreen.ruta){
            BottomAppBar(
                modifier = Modifier.height(50.dp).padding(0.dp),
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Distribuir los iconos usando `weight`
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.toolbar1),
                            description = "Home",
                            isSelected = selectedItem == Rutas.HomeScreen.ruta,
                            onClick = {
                                selectedItem = Rutas.HomeScreen.ruta
                                navController.navigate(Rutas.HomeScreen.ruta)
                            },
                            modifier = Modifier.weight(1f) // Cada icono tiene el mismo peso
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.toolbar2),
                            description = "TransaccionsScreen",
                            isSelected = selectedItem == Rutas.TransaccionsScreen.ruta,
                            onClick = {
                                selectedItem = Rutas.TransaccionsScreen.ruta
                                navController.navigate(Rutas.TransaccionsScreen.ruta)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.toolbar3),
                            description = "Menu",
                            isSelected = selectedItem == Rutas.MyCardScreen.ruta,
                            onClick = {
                                selectedItem = Rutas.MyCardScreen.ruta
                                navController.navigate(Rutas.MyCardScreen.ruta)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.toolbar4),
                            description = "PagoDeServiciosScreen",
                            isSelected = selectedItem == Rutas.PagoDeServiciosScreen.ruta,
                            onClick = {
                                selectedItem = Rutas.PagoDeServiciosScreen.ruta
                                navController.navigate(Rutas.PagoDeServiciosScreen.ruta)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        BottomBarIcon(
                            painter = painterResource(id = R.drawable.toolbar5),
                            description = "MyAcountyScreen",
                            isSelected = selectedItem == Rutas.MyAcountyScreen.ruta,
                            onClick = {
                                selectedItem = Rutas.MyAcountyScreen.ruta
                                navController.navigate(Rutas.MyAcountyScreen.ruta)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            )
        }
        }
    ) {
        NavHost(navController = navController, startDestination = Rutas.HomeScreen.ruta) {
            composable(Rutas.HomeScreen.ruta) { HomeScreen() }
            composable(Rutas.TransaccionsScreen.ruta) { TransactionScreen() }
            composable(Rutas.MyCardScreen.ruta) { MycardScreen() }
            composable(Rutas.PagoDeServiciosScreen.ruta) { PagoDeServiciosScreen(navController) }
            composable(Rutas.MyAcountyScreen.ruta) { MyAcountyScreen() }
            composable(Rutas.CargarSubeScreen.ruta) { CargarSubeScreen(navController) }
        }
    }
}

@Composable
fun BottomBarIcon(
    painter: Painter,
    description: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(0.dp) // Asegúrate de que no haya padding adicional
    ) {
        // Línea verde en la parte superior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp) // Altura de la línea
                .background(if (isSelected) Color(0xFF0FD08B) else Color.Transparent)
        )

        // Espacio entre la línea y el ícono
        Spacer(modifier = Modifier.height(0.dp)) // Si no deseas espacio, ajusta a 0.dp

        IconButton(onClick = onClick) {
            Icon(
                painter = painter,
                contentDescription = description,
                modifier = Modifier.size(88.dp), // Tamaño del ícono
                tint = if (isSelected) Color(0xFF0FD08B) else Color.Gray // Color del ícono
            )
        }
    }
}
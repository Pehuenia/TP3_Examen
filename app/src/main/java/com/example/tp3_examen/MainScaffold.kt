package com.example.tp3_examen


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.R
import com.example.tp3_examen.components.BottomBarIcon
import com.example.tp3_examen.components.drawermenu.NavDrawer
import com.example.tp3_examen.navigation.Rutas
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.HomeScreen
import com.example.tp3_examen.ui.screens.MyCardScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen
import com.example.tp3_examen.ui.screens.TransactionScreen
import com.example.tp3_examen.viewmodels.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun MainScaffold(
    navController: NavHostController,
    selectedItem: String,
    onBottomBarItemSelected: (String) -> Unit,
    onDrawerIconClicked: () -> Unit
) {
    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute != Rutas.CargarSubeScreen.ruta) {
                BottomAppBar(
                    modifier = Modifier.height(70.dp),
                    content = {
                        Row(
                            modifier = Modifier.height(70.dp),
                        ) {
                            // Coloca aquí los iconos de la barra inferior
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        // Agrega `Modifier.padding(innerPadding)` al `NavHost`
        NavHost(
            navController = navController,
            startDestination = Rutas.HomeScreen.ruta,
            modifier = Modifier.padding(innerPadding) // Utiliza el padding aquí
        ) {
            composable(Rutas.HomeScreen.ruta) { HomeScreen() }
            composable(Rutas.TransaccionsScreen.ruta) { TransactionScreen() }
            composable(Rutas.MyCardScreen.ruta) { MyCardScreen() }
            composable(Rutas.PagoDeServiciosScreen.ruta) { PagoDeServiciosScreen(navController) }
            composable(Rutas.CargarSubeScreen.ruta) { CargarSubeScreen(navController) }
        }
    }
}

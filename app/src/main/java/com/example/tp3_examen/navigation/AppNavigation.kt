package com.example.tp3_examen.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.R
import com.example.tp3_examen.components.drawermenu.NavDrawer
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.HomeScreen
import com.example.tp3_examen.ui.screens.MyCardScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen
import com.example.tp3_examen.ui.screens.TransactionScreen
import com.example.tp3_examen.viewmodels.LoginViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(viewModel: LoginViewModel) {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(Rutas.HomeScreen.ruta) } // Estado para el ítem seleccionado
    val scope = rememberCoroutineScope()
    //val viewModel: NavDrawerViewModel = viewModel(factory = DrawerViewModelFactory())

    var isDrawerOpen by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) { // Detectar gestos de deslizamiento
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount < -50 && !isDrawerOpen) {
                        isDrawerOpen = true
                    } else if (dragAmount > 50 && isDrawerOpen) {
                        isDrawerOpen = false
                    }
                    change.consume()
                }
            }
    ) {
        Scaffold(
            bottomBar = {
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route


                if (currentRoute != Rutas.CargarSubeScreen.ruta) {
                    BottomAppBar(
                        modifier = Modifier.height(70.dp),
                        content = {
                            Row(
                                modifier = Modifier
                                    .height(70.dp),
                                //horizontalArrangement = Arrangement.SpaceEvenly
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
                                    isSelected = false,
                                    onClick = { isDrawerOpen = true },
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
                composable(Rutas.MyCardScreen.ruta) { MyCardScreen() }
                composable(Rutas.PagoDeServiciosScreen.ruta) { PagoDeServiciosScreen(navController) }
                composable(Rutas.CargarSubeScreen.ruta) { CargarSubeScreen(navController) }
            }
        }


        if (isDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
                    .clickable { isDrawerOpen = false } // Cerrar al tocar fuera
            )
        }

        AnimatedVisibility(
            visible = isDrawerOpen,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth }, // Entra desde el borde derecho de la pantalla
                animationSpec = tween(
                    durationMillis = 500,
                    easing = EaseInOut
                )
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth - 100 }, // Sale hacia la derecha pero deja 100dp visible
                animationSpec = tween(
                    durationMillis = 300,
                    easing = EaseInOut
                )
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(400.dp) // Ancho del drawer
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(0.dp)
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            if (dragAmount > 30) {
                                isDrawerOpen = false
                            }
                            change.consume()
                        }
                    }
            ) {
                NavDrawer()
            }
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

    ) {
        // Línea verde en la parte superior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp) // Altura de la línea
                .background(if (isSelected) Color(0xFF0FD08B) else Color.Transparent)

        )

        IconButton(onClick = onClick, modifier = Modifier.size(70.dp)) {
            Icon(
                painter = painter,
                contentDescription = description,
                modifier = Modifier.fillMaxSize(), // Tamaño del ícono
                tint = if (isSelected) Color(0xFF0FD08B) else Color.Gray // Color del ícono
            )
        }
    }
}



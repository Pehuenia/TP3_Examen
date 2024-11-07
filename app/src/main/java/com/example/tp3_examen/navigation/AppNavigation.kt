package com.example.tp3_examen.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.MainScaffold
import com.example.tp3_examen.components.drawermenu.CustomDrawer
import com.example.tp3_examen.viewmodels.LoginViewModel
import com.example.tp3_examen.viewmodels.drawerviewmodel.DrawerViewModelFactory
import com.example.tp3_examen.viewmodels.drawerviewmodel.NavDrawerViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(viewModel: LoginViewModel) {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(Rutas.HomeScreen.ruta) } // Estado para el ítem seleccionado
    val drawerViewModel: NavDrawerViewModel = viewModel(factory = DrawerViewModelFactory())
    var isDrawerOpen by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount < -60 && !isDrawerOpen) {
                        isDrawerOpen = true
                    } else if (dragAmount > 60 && isDrawerOpen) {
                        isDrawerOpen = false
                    }
                    change.consume()
                }
            }
    ) {
        MainScaffold(
            navController = navController,
            selectedItem = selectedItem,
            onBottomBarItemSelected = { selectedItem = it },
            onDrawerIconClicked = { isDrawerOpen = true }
        )

        CustomDrawer(
            isDrawerOpen = isDrawerOpen,
            onCloseDrawer = { isDrawerOpen = false },
            drawerViewModel = drawerViewModel
        )
    }
}
/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(viewModel: LoginViewModel) {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(Rutas.HomeScreen.ruta) } // Estado para el ítem seleccionado
    val scope = rememberCoroutineScope()
    val drawerViewModel: NavDrawerViewModel = viewModel(factory = DrawerViewModelFactory())
    var isDrawerOpen by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) { // Detectar gestos de deslizamiento
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount < -60 && !isDrawerOpen) {
                        isDrawerOpen = true
                    } else if (dragAmount > 60 && isDrawerOpen) {
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


        // Drawer personalizado con fondo para cierre al tocar fuera o deslizar
        if (isDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
                    .clickable { isDrawerOpen = false } // Cerrar al tocar fuera
            )

            // Drawer que se abre desde la derecha con deslizamiento
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(400.dp)
                    .align(Alignment.CenterEnd)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(0.dp)
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            // Cerrar el drawer si se desliza hacia la derecha
                            if (dragAmount < -30) { // Ajusta el valor según la sensibilidad que prefieras
                                isDrawerOpen = false
                            }
                            change.consume()
                        }
                    }
            ) {
                NavDrawer(drawerViewModel) // Sin parámetros adicionales
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


*/
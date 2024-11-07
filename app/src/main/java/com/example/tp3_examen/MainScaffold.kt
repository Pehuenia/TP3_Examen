package com.example.tp3_examen


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tp3_examen.components.BottomBarIcon
import com.example.tp3_examen.navigation.Rutas
import com.example.tp3_examen.ui.screens.CargarSubeScreen
import com.example.tp3_examen.ui.screens.HomeScreen
import com.example.tp3_examen.ui.screens.MyCardScreen
import com.example.tp3_examen.ui.screens.PagoDeServiciosScreen
import com.example.tp3_examen.ui.screens.SplashScreen
import com.example.tp3_examen.ui.screens.TransactionScreen
import com.example.tp3_examen.viewmodels.mainviewmodel.MainViewModel


@Composable
fun MainScaffold(
    navController: NavHostController,
    selectedItem: String,
    onBottomBarItemSelected: (String) -> Unit,
    onDrawerIconClicked: () -> Unit
) {

    Scaffold(
        bottomBar = {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute != Rutas.CargarSubeScreen.ruta) {
                BottomAppBar(
                    modifier = Modifier.height(70.dp),
                    content = {
                        Row(modifier = Modifier.height(70.dp)) {
                            BottomBarIcon(
                                painter = painterResource(id = R.drawable.toolbar1),
                                description = "Home",
                                isSelected = selectedItem == Rutas.HomeScreen.ruta,
                                onClick = {
                                    onBottomBarItemSelected(Rutas.HomeScreen.ruta)
                                    navController.navigate(Rutas.HomeScreen.ruta)
                                },
                                modifier = Modifier.weight(1f)
                            )
                            BottomBarIcon(
                                painter = painterResource(id = R.drawable.toolbar2),
                                description = "TransaccionsScreen",
                                isSelected = selectedItem == Rutas.TransaccionsScreen.ruta,
                                onClick = {
                                    onBottomBarItemSelected(Rutas.TransaccionsScreen.ruta)
                                    navController.navigate(Rutas.TransaccionsScreen.ruta)
                                },
                                modifier = Modifier.weight(1f)
                            )
                            BottomBarIcon(
                                painter = painterResource(id = R.drawable.toolbar3),
                                description = "Menu",
                                isSelected = selectedItem == Rutas.MyCardScreen.ruta,
                                onClick = {
                                    onBottomBarItemSelected(Rutas.MyCardScreen.ruta)
                                    navController.navigate(Rutas.MyCardScreen.ruta)
                                },
                                modifier = Modifier.weight(1f)
                            )
                            BottomBarIcon(
                                painter = painterResource(id = R.drawable.toolbar4),
                                description = "PagoDeServiciosScreen",
                                isSelected = selectedItem == Rutas.PagoDeServiciosScreen.ruta,
                                onClick = {
                                    onBottomBarItemSelected(Rutas.PagoDeServiciosScreen.ruta)
                                    navController.navigate(Rutas.PagoDeServiciosScreen.ruta)
                                },
                                modifier = Modifier.weight(1f)
                            )
                            BottomBarIcon(
                                painter = painterResource(id = R.drawable.toolbar5),
                                description = "MyAcountyScreen",
                                isSelected = false,
                                onClick = { onDrawerIconClicked() },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Rutas.HomeScreen.ruta,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Rutas.HomeScreen.ruta) { HomeScreen() }
            composable(Rutas.TransaccionsScreen.ruta) { TransactionScreen() }
            composable(Rutas.MyCardScreen.ruta) { MyCardScreen() }
            composable(Rutas.PagoDeServiciosScreen.ruta) { PagoDeServiciosScreen(navController) }
            composable(Rutas.CargarSubeScreen.ruta) { CargarSubeScreen(navController) }
        }
    }
}

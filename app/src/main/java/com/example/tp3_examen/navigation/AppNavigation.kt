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
import com.example.tp3_examen.viewmodels.drawerviewmodel.DrawerViewModelFactory
import com.example.tp3_examen.viewmodels.drawerviewmodel.NavDrawerViewModel
import com.example.tp3_examen.viewmodels.mainviewmodel.MainViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
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
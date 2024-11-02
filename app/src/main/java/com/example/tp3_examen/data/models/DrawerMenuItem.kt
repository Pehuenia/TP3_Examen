package com.example.tp3_examen.data.models

import androidx.compose.runtime.Composable
import com.example.tp3_examen.components1.ChevronIcon


data class DrawerMenuItem(
    val text: String,
    val icon: @Composable () -> Unit
)

val chevronIcon: @Composable () -> Unit = { ChevronIcon() }

val drawerMenuItems = listOf(
    DrawerMenuItem("Mis datos", { chevronIcon() }),
    DrawerMenuItem("Mi CVU", { chevronIcon() }),
    DrawerMenuItem("Configuración", { chevronIcon() }),
    DrawerMenuItem("Ayuda", { chevronIcon() }),
    DrawerMenuItem("Términos y condiciones", { chevronIcon() }),
    DrawerMenuItem("Cerrar sesión", { chevronIcon() })

)
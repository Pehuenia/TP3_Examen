package com.example.tp3_examen.data.models

import androidx.compose.runtime.Composable
import com.example.tp3_examen.components.ChevronIcon


data class DrawerMenuItem(
    val text: String,
    val icon: @Composable () -> Unit

)

val chevronIcon: @Composable () -> Unit = { ChevronIcon() }



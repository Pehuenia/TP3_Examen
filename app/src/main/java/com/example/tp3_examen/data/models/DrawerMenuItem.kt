package com.example.tp3_examen.data.models

import androidx.compose.runtime.Composable
import com.example.tp3_examen.components1.ChevronIcon


data class DrawerMenuItem(
    val text: String,
    val icon: @Composable () -> Unit

)

val chevronIcon: @Composable () -> Unit = { ChevronIcon() }



package com.example.tp3_examen.data.models

import androidx.compose.runtime.Composable


data class DrawerMenuItem(
    val text: String,
    val icon: @Composable () -> Unit
)

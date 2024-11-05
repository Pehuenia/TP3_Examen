package com.example.tp3_examen.data.models

import androidx.compose.runtime.Composable

data class SwitchItem(
    val title: String,
    val icon: @Composable () -> Unit,
    val isSwitchOn: Boolean
)



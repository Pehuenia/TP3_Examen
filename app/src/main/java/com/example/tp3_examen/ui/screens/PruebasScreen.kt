package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.tp3_examen.components1.CheckIcon
import com.example.tp3_examen.components1.ChevronIcon
import com.example.tp3_examen.components1.CircularIcon

@Composable
fun PruebasScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ChevronIcon()
        CheckIcon()
        CircularIcon()
    }
}
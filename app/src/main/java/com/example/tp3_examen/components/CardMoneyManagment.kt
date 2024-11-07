package com.example.tp3_examen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun CardMoneyManagement() {
    CustomCard(height = 96) {
        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ActionRow(
                actions = listOf(
                    "CARGAR\n DINERO" to R.drawable.servicios_cargar_dinero,
                    "EXTRAER\n DINERO" to R.drawable.servicios_extraer_dinero,
                    "TRANSFERIR\n DINERO" to R.drawable.servicios_transferencia
                )
            )
        }
    }
}

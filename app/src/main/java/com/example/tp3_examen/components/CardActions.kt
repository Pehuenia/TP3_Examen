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
fun CardActions() {
    CustomCard(height = 192) {
        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly // Distribuye las filas de manera uniforme
        ) {
            // Primera fila de acciones
            ActionRow(
                actions = listOf(
                    "CARGAR\n DINERO" to R.drawable.servicios_cargar_dinero,
                    "EXTRAER\n DINERO" to R.drawable.servicios_extraer_dinero,
                    "SEGUIR\n MI PRÉSTAMO" to R.drawable.servicios_prestamos
                ),
                modifier = Modifier.weight(1f) // Permite que cada fila ocupe una proporción de la altura
            )

            // Segunda fila de acciones
            ActionRow(
                actions = listOf(
                    "RECARGA\n SUBE" to R.drawable.servicios_recarga_sube,
                    "RECARGA\n CELULAR" to R.drawable.servicios_recarga_celu,
                    "PAGAR\n SERVICIO" to R.drawable.servicios_pago_servicio
                ),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


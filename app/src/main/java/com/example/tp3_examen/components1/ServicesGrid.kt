package com.example.tp3_examen.components1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun ServicesGrid() {
    val services = listOf(
        Triple(R.drawable.servicios_recarga_sube, "RECARGA SUBE", R.drawable.img),
        Triple(R.drawable.servicios_recarga_celu, "RECARGA CELULAR", R.drawable.img),
        Triple(R.drawable.servicios_pago_servicio, "PAGO DE SERVICIOS", R.drawable.img),
        Triple(R.drawable.servicios_directv, "DIRECT TV PREPAGO", R.drawable.img)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp), // Reduce el espacio en los bordes de la pantalla
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Reduce espacio entre tarjetas horizontalmente
        verticalArrangement = Arrangement.spacedBy(8.dp), // Reduce espacio entre tarjetas verticalmente
    ) {
        items(services) { (iconRes, text, backgroundRes) ->
            CardService(
                iconRes = iconRes,
                text = text,
                backgroundRes = backgroundRes
            )
        }
    }
}



package com.example.tp3_examen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3_examen.R
import com.example.tp3_examen.navigation.Rutas

@Composable
fun ServicesGrid(navController: NavController) {


    val services = listOf(
        Triple(R.drawable.servicios_recarga_sube, "RECARGA SUBE", R.drawable.circulo),
        Triple(R.drawable.servicios_recarga_celu, "RECARGA CELULAR", R.drawable.circulo),
        Triple(R.drawable.servicios_pago_servicio, "PAGO DE SERVICIOS", R.drawable.circulo),
        Triple(R.drawable.servicios_directv, "DIRECT TV PREPAGO", R.drawable.circulo)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(services) { (iconRes, text, backgroundRes) ->
            CardService(
                iconRes = iconRes,
                text = text,
                backgroundRes = backgroundRes,
                onClick = {
                    when (iconRes) {
                        R.drawable.servicios_recarga_sube -> navController.navigate(Rutas.CargarSubeScreen.ruta)
                    }
                }

            )
        }
    }
}





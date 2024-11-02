package com.example.tp3_examen.components1

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun ActionRow(actions: List<Pair<String, Int>>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth() // Llena el ancho disponible
    ) {
        actions.forEach { action ->
            Column(
                Modifier
                    .weight(1f) // Distribuye el espacio entre columnas de forma equitativa
                    .fillMaxHeight()
                    .border(1.dp, colorResource(id = R.color.gray_500)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ActionItem(label = action.first, iconResId = action.second)
            }
        }
    }
}

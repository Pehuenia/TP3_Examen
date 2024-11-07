package com.example.tp3_examen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // Primera fila de acciones
            ActionRow(
                actions = listOf(
                    stringResource(id = R.string.load_money) to R.drawable.servicios_cargar_dinero,
                    stringResource(id = R.string.extract_money) to R.drawable.servicios_extraer_dinero,
                    stringResource(id = R.string.follow_loan) to R.drawable.servicios_prestamos
                ),
                modifier = Modifier.weight(1f)
            )
            ActionRow(
                actions = listOf(
                    stringResource(id = R.string.load_sube) to R.drawable.servicios_recarga_sube,
                    stringResource(id = R.string.load_phone) to R.drawable.servicios_recarga_celu,
                    stringResource(id = R.string.pay_service) to R.drawable.servicios_pago_servicio
                ),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


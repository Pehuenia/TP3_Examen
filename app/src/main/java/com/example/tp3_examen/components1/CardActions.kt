package com.example.tp3_examen.components1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

@Composable
fun CardActions() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white),
        ),
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .height(192.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                BorderStroke(1.dp, colorResource(id = R.color.gray_500)),
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Primera fila de acciones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Ocupa la mitad del espacio vertical
            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, colorResource(id = R.color.gray_500)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ActionItem("CARGAR\n DINERO", R.drawable.servicios_cargar_dinero)
                }
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, colorResource(id = R.color.gray_500)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ActionItem("EXTRAER\n DINERO", R.drawable.servicios_extraer_dinero)
                }
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, colorResource(id = R.color.gray_500)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ActionItem("SEGUIR\n MI PRÉSTAMO", R.drawable.servicios_prestamos)
                }
            }

            // Segunda fila de acciones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Ocupa la mitad del espacio vertical
            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, colorResource(id = R.color.gray_500)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ActionItem("RECARGA\n SUBE", R.drawable.servicios_recarga_sube)
                }
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, colorResource(id = R.color.gray_500)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ActionItem("RECARGA\n CELULAR", R.drawable.servicios_recarga_celu)
                }
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, colorResource(id = R.color.gray_500)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ActionItem("PAGAR\n SERVICIO", R.drawable.servicios_pago_servicio)
                }
            }
        }
    }
}

@Composable
fun ActionItem(label: String, iconResId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Acción del botón */ },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = colorResource(id = R.color.green),
            modifier = Modifier
                .size(32.dp)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                color = colorResource(id = R.color.black),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.4.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center,
                maxLines = Int.MAX_VALUE, // Permitir todas las líneas necesarias para envolver el texto
                overflow = TextOverflow.Clip, // Sin truncar el texto
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
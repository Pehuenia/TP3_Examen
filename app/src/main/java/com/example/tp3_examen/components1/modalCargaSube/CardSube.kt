package com.example.tp3_examen.components1.modalCargaSube

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.CustomCard

@Composable
fun CardSube() {
    CustomCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Logo de SUBE con fondo azul
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(colorResource(id = R.color.sube_blue)),  // Color de fondo azul para el logo
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.sube),
                    contentDescription = "Logo Sube",
                    modifier = Modifier
                        .width(106.dp)
                        .height(44.dp)
                )
            }

            // Línea separadora superior
            Spacer(
                modifier = Modifier
                    .width(288.dp)
                    .height(1.dp)
                    .background(colorResource(id = R.color.gray_500))
            )

            // Número de tarjeta
            Text(
                text = "Tarjeta No: 6061 3580 2384 9041",
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 22.4.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Línea separadora inferior
            Spacer(
                modifier = Modifier
                    .width(288.dp)
                    .height(1.dp)
                    .background(colorResource(id = R.color.gray_500))
            )

            // Saldo
            Text(
                text = "$200,00",
                color = colorResource(id = R.color.purple_900),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 35.2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(bottom = 8.dp)
            )
        }
    }
}

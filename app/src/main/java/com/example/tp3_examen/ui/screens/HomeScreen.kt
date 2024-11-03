package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.CardActions
import com.example.tp3_examen.components1.CreditCard

@Composable
fun HomeScreen() {
    Column (
        modifier = Modifier
            .background(colorResource(id = R.color.gray_100))
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 24.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        // texto bienvenida
        Column (Modifier.padding(12.dp)
                 .fillMaxWidth()) {
            Text(
                text = "\uD83D\uDC4B Hola Mariana",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 21.6.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Left,
                    color = colorResource(id = R.color.black)
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Ultimo acceso: Mar 01, 2020 4:55 PM",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 14.4.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Left,
                    color = colorResource(id = R.color.gray_900)
                )
            )


        }
        // tarjeta de credito
        CreditCard(
            cardNumber = "4957 7124 8154 2582"
        )
        //saldo disponible

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SALDO DISPONIBLE",
                color = colorResource(id = R.color.black),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 41.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = "$ 1.322,78",
                color = colorResource(id = R.color.black),
                style = TextStyle(
                    fontSize = 44.sp,
                    lineHeight = 35.2.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }

        //alerta
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.red_900), shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column( modifier = Modifier.weight(0.8f)
            ) {
                Text(
                    text = "La cuota de tu préstamo está próxima a vencer",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.4.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
                Text(
                    text = "Ver préstamo",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.4.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

            }
            Column(
                modifier = Modifier.weight(0.2f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.flecha_derecha),
                    contentDescription = "Right Arrow",
                    modifier = Modifier.size(10.dp),
                    tint = colorResource(id = R.color.white)
                )

            }


        }

        CardActions()

}

}
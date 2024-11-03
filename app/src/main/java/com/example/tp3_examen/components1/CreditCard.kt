package com.example.tp3_examen.components1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

@Composable
fun CreditCard(cardNumber: String) {
    var isRevealed by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(212.dp)
                .shadow(
                    6.dp,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(
                        8.dp,
                        0.dp,
                        0.dp,
                        0.dp
                    )
                ),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bkg),
                    contentDescription = "Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(id = R.drawable.bkg_1),
                    contentDescription = "Triangle Bottom Left",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Logo de Mastercard
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-16).dp, y = (-24).dp)
                        .size(55.dp, 34.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vector),
                        contentDescription = "Connector",
                        modifier = Modifier
                            .size(15.95.dp, 26.06.dp)
                            .offset(19.26.dp, 3.97.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.vector1),
                        contentDescription = "Red Circle",
                        modifier = Modifier
                            .size(26.81.dp, 33.14.dp)
                            .offset(0.43.dp, 0.43.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.vector2),
                        contentDescription = "Yellow Circle",
                        modifier = Modifier
                            .size(26.81.dp, 33.15.dp)
                            .offset(27.24.dp, 0.42.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Card Logo",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-16).dp, y = 16.dp)
                        .size(50.dp, 28.09.dp)
                )

                // Número de tarjeta
                Text(
                    text = if (isRevealed) cardNumber else "${cardNumber.substring(0, 4)} **** ***** ${cardNumber.substring(15)}",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 16.dp, y = 40.dp)
                )

                // Fecha de expiración
                Text(
                    text = "05/23", //por si esta hardcodeado la fecha
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 16.dp, y = 68.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { isRevealed = !isRevealed },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono de ojo
            val eyeIcon = if (isRevealed) {
                painterResource(id = R.drawable.ojo_tachado)
            } else {
                painterResource(id = R.drawable.ojo_abierto)
            }

            Icon(
                painter = eyeIcon,
                contentDescription = "Eye Icon",
                modifier = Modifier.size(20.dp),
                tint = colorResource(id = R.color.purple_900)
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = if (isRevealed) "Ocultar datos" else "Mostrar datos",
                color = colorResource(id = R.color.purple_900),
            )
        }
    }
}
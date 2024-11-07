package com.example.tp3_examen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

@Composable
fun CreditCard() {
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
                        8.dp, 0.dp, 0.dp, 0.dp
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
                    painter = painterResource(id = R.drawable.bkg1),
                    contentDescription = "Background1",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-16).dp, y = (-24).dp)
                        .size(55.dp, 34.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mastercard),
                        contentDescription = "Connector",
                        modifier = Modifier
                            .size(15.95.dp, 26.06.dp)
                            .offset(19.26.dp, 3.97.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.mastercard1),
                        contentDescription = "Red Circle",
                        modifier = Modifier
                            .size(26.81.dp, 33.14.dp)
                            .offset(0.43.dp, 0.43.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.mastercar2),
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
                     text = if (isRevealed) "4957 7124 8154 5824" else "4957 **** **** 5824",  // si esta hardcodeado el numero de tarjeta
                   // text = if (isRevealed) cardNumber else "${cardNumber.substring(0, 4)} **** ***** ${cardNumber.substring(15)}", //le paso por parametros
                    style = TextStyle(
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 16.dp, y = 40.dp)
                )

                // Fecha de expiración
                Text(
                    text = "05/23", //por si esta hardcodeado la fecha
                //  text = expirationDate,// si le paso por parametros
                    style = TextStyle(
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp
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
            val eyeIcon = if (isRevealed) {
                painterResource(id = R.drawable.crossed_out_eye)
            } else {
                painterResource(id = R.drawable.open_eye)
            }

            Icon(
                painter = eyeIcon,
                contentDescription = "Eye Icon",
                modifier = Modifier.size(20.dp),
                tint = colorResource(id = R.color.purple_900)
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = if (isRevealed) stringResource(id = R.string.hide_data) else stringResource(id =R.string.show_data),
                color = colorResource(id = R.color.purple_900),
            )
        }
    }
}
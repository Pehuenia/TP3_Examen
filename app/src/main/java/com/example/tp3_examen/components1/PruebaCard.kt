package com.example.tp3_examen.components1

import android.content.ClipData
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.stringResource

@Composable
fun PruebaCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(153.dp)
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
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                        fontSize = 32.sp,
                        lineHeight = 35.2.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Divider(
                color = colorResource(id = R.color.gray_500),
                thickness = 1.dp
            )

            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle()) {
                            append("CVU: ")
                        }
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("000654326538129540653")
                        }
                    },
                    color = colorResource(id = R.color.black),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp,
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth(),
                )

                Text(
                    text = stringResource(id = R.string.copy),
                    color = colorResource(id = R.color.purple_900),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxWidth()
                        .clickable {
                        }
                )
            }
        }
    }
}






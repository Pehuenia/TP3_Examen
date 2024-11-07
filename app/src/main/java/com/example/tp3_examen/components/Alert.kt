package com.example.tp3_examen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

@Composable
fun Alert(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.red_900), shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.8f)
        ) {
            Text(
                text = stringResource(id = R.string.warning),
                color = colorResource(id = R.color.white),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.4.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = stringResource(id = R.string.see_loan),
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
}
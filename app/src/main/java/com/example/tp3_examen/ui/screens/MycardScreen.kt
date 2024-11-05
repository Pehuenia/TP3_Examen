package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.CreditCard


@Composable

fun MycardScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 0.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.my_card),
                color = colorResource(id = R.color.black),
                fontSize = 18.sp,
                lineHeight = 21.6.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.virtual_card),
                modifier = Modifier
                    .fillMaxWidth(),
                color = colorResource(id = R.color.black),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 14.4.sp,
                textAlign = TextAlign.Left
            )
            CreditCard(
                cardNumber = "4957 7124 8154 2582" ,
                expirationDate = "12/23"
            )
            }
        Divider(
            color = colorResource(id = R.color.gray_500),
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()

        )
        Text(
            text = stringResource(id = R.string.text_card),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            color = colorResource(id = R.color.black),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 19.6.sp,
            textAlign = TextAlign.Left
        )



        Text(
            text = stringResource(id = R.string.physical_card),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
            color = colorResource(id = R.color.black),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 14.4.sp,
            textAlign = TextAlign.Left
        )


    }




}
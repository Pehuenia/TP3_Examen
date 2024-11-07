package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components.ActionRow
import com.example.tp3_examen.components.CustomCard
import com.example.tp3_examen.components.PruebaCard
import com.example.tp3_examen.components.TransactionsList

@Composable
fun TransactionScreen() {
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
                text = stringResource(id = R.string.my_account),
                color = colorResource(id = R.color.black),
                fontSize = 18.sp,
                lineHeight = 21.6.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center
            )
            PruebaCard()
            CustomCard(height = 96) {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionRow(
                        actions = listOf(
                            stringResource(id = R.string.charge) to R.drawable.servicios_recarga_sube,
                            "EXTRAER\nDINERO" to R.drawable.servicios_extraer_dinero,
                            "TRANSFERIR\nDINERO" to R.drawable.transfer_icon
                        )
                    )
                }
            }
        }
        Column(
            modifier = Modifier.padding(0.dp),
        ) {
            TransactionsList()
        }
    }
}

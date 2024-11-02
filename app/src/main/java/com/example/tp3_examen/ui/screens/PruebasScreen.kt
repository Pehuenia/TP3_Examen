package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.tp3_examen.componentes.navigationdrawer.DrawerHeader
import com.example.tp3_examen.components1.CircularImage


@Composable
fun PruebasScreen() {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



       DrawerHeader()
    }
}

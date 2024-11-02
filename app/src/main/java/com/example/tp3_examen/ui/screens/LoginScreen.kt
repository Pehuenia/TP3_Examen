package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.green_800))
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_mas_nombre),
            contentDescription = "Logo",
            modifier = Modifier
                .width(250.dp)
                .height(35.dp)
                .padding(0.dp)
                .align(Alignment.TopCenter)
                .offset(y = 80.dp) // Adjust the offset as needed
        )

        Image(
            painter = painterResource(id = R.drawable.texto),
            contentDescription = "Texto",
            modifier = Modifier
                .width(280.dp)
                .height(90.dp)
                .padding(0.dp)
                .align(Alignment.TopStart)
                .offset(x = 55.dp, y = 150.dp) // Adjust the offset as needed
        )
    }
}
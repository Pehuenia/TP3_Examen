package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tp3_examen.components1.ServicesGrid

@Composable
fun PagoDeServiciosScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.padding(top = 60.dp), // Espacio en la parte superior
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pago de servicios",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2A1846),
            modifier = Modifier.padding(bottom = 16.dp) // Espacio entre el título y las tarjetas
        )
        ServicesGrid(navController)
    }
}

package com.example.tp3_examen.components1.switchbutton

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SwitchButton2() {
    var isChecked by remember { mutableStateOf(false) }

    // Animación para mover el círculo según el estado del switch
    val thumbOffset by animateDpAsState(
        targetValue = if (isChecked) 28.dp else 4.dp,
        animationSpec = tween(durationMillis = 300)
    )

    // Contenedor del Switch
    Box(
        modifier = Modifier
            .size(width = 60.dp, height = 32.dp)
            .background(
                color = if (isChecked) Color(0xFF00BCD4) else Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { isChecked = !isChecked },
        contentAlignment = Alignment.CenterStart
    ) {
        // Círculo del Switch
        Box(
            modifier = Modifier
                .size(24.dp)
                .offset(x = thumbOffset)
                .background(color = Color.White, shape = CircleShape)
        )
    }
}

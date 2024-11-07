package com.example.tp3_examen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun WavingHandIcon() {
    Image(
        painter = painterResource(R.drawable.waving_hand2),
        contentDescription = "Waving Hand",
        modifier = Modifier.size(26.dp)
    )
}
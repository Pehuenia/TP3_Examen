package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.CircularIcon
import com.example.tp3_examen.components1.switchbutton.SettingsCard
import com.example.tp3_examen.components1.switchbutton.SwitchItemBackground


@Composable
fun PruebasScreen() {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var isChecked by remember { mutableStateOf(false) }

        SettingsCard(
            text = "Dark Mode",
            isChecked = isChecked,
            onCheckedChange = { isChecked = it },
            IconComponent = { CircularIcon() }
        )





    }
}

@Composable
fun GreenCircleIcon() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color(0xFF00C853), CircleShape)
    )
}

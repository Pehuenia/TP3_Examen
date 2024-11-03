package com.example.tp3_examen.components1.switchbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

@Composable
fun SettingsCard(
    modifier: Modifier = Modifier,
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    IconComponent: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(13.dp)
            .background(color = Color.White, shape = RoundedCornerShape(13.dp))
            .border(width = 1.dp, color = colorResource(R.color.gray_500), shape = RoundedCornerShape(13.dp))
            .padding(13.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Switch arriba a la izquierda
            Row(
                modifier = Modifier.fillMaxWidth().padding(0.dp)) {
                SwitchButton2(isChecked = isChecked, onCheckedChange = onCheckedChange)

            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Texto a la izquierda
                Text(
                    text = text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )

                // Ícono verde a la derecha
                IconComponent()
            }
        }
    }
}
/*
@Composable
fun CustomSwitch(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier) {
    // Acá va el código del CustomSwitch
    // para `isChecked` y `onCheckedChange`
    Box(
        modifier = Modifier
            .size(width = 56.dp, height = 29.dp)
            .padding(start = 0.dp, top = 0.dp)
            .background(
                color = if (isChecked) Color(0xFF00BCD4) else Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onCheckedChange(!isChecked) },
        contentAlignment = Alignment.CenterStart
    ) {
        val thumbOffset = if (isChecked) 28.dp else 4.dp
        Box(                                                           //círculo del switch button
            modifier = Modifier
                .size(22.dp)
                .offset(x = thumbOffset)
                .background(color = Color.White, shape = CircleShape)
        )
    }
}


*/
/*

@Composable
fun GreenCircleIcon() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color(0xFF00C853), CircleShape)
    )
}

*/

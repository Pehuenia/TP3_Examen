package com.example.tp3_examen.components.switchbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .padding(start = 12.dp, end = 12.dp, top = 25.dp, bottom = 4.dp)
            .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(13.dp))
            .border(
                width = 1.dp,
                color = colorResource(R.color.gray_500),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Switch arriba a la izquierda
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)) {
                SwitchButton2(isChecked = isChecked, onCheckedChange = onCheckedChange)  //SettingCard no necesita recibir el ThemeViewModel como parámetro, porque onCheckedChenge es suficiene para delegar la acción a SwitchButton2 para actualizar el estado.

            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Texto a la izquierda
                Text(
                    text = text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Ícono verde a la derecha
                IconComponent()
            }
        }
    }
}

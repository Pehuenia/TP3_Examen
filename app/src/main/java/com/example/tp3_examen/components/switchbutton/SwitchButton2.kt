package com.example.tp3_examen.components.switchbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun SwitchButton2(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {

    Box(
        modifier = Modifier
            .size(width = 58.dp, height = 29.dp)
            .background(
                color = if (isChecked) colorResource(R.color.blue) else Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onCheckedChange(!isChecked) },
        contentAlignment = Alignment.CenterStart
    ) {
        val thumbOffset = if (isChecked) 28.dp else 4.dp
        Box(
            modifier = Modifier
                .size(24.dp)
                .offset(x = thumbOffset)
                .background(color = Color.White, shape = CircleShape)
        )
    }
}
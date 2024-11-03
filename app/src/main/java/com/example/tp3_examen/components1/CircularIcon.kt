package com.example.tp3_examen.components1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun CircularIcon(
    size: Dp = 31.dp,
    backgroundColor: Color = colorResource(id = R.color.green_800),
    icon: ImageVector? = null,
    iconTint: Color = Color.White,
    iconSize: Dp? = null
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        if (icon != null)
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(iconSize ?: (size * 0.5f)) // Tamaño del ícono en relación al círculo

        )
    }
}


package com.example.tp3_examen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun ChevronIcon(){
    val icon =  ImageVector.vectorResource(id = R.drawable.chevron_icon)
    val iconSize = 26.dp
    CircularIcon(icon = icon, iconSize = iconSize)


}
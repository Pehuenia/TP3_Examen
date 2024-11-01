package com.example.tp3_examen.components1

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
 fun  CheckIcon() {
    val icon =  ImageVector.vectorResource(id = R.drawable.check_icon)
    val iconSize = 60.dp
    CircularIcon(size = 115.dp, icon = icon, iconSize = iconSize )

}
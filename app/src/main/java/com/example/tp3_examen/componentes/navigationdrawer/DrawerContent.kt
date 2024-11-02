package com.example.tp3_examen.componentes.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.data.models.drawerMenuItems


@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {

        DrawerHeader()

        drawerMenuItems.forEachIndexed { index, item ->
            DrawerItem(item = item)
            if (index < drawerMenuItems.size - 1) {
                HorizontalDivider(thickness = 1.dp, color = Color.Gray)
            }
        }
    }
}

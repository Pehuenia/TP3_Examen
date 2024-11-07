package com.example.tp3_examen.components.drawermenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.viewmodels.drawerviewmodel.NavDrawerViewModel

@Composable
fun CustomDrawer(
    isDrawerOpen: Boolean,
    onCloseDrawer: () -> Unit,
    drawerViewModel: NavDrawerViewModel,
    drawerWidth: Dp = 400.dp
) {
    if (isDrawerOpen) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
                .clickable { onCloseDrawer() }
        )

        // Envolver el drawer en otro Box con contentAlignment para mantenerlo a la derecha
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.CenterEnd // Alinea el contenido al extremo derecho
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(drawerWidth)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(0.dp)
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            if (dragAmount < -30) { // Cerrar al deslizar hacia la derecha
                                onCloseDrawer()
                            }
                            change.consume()
                        }
                    }
            ) {
                NavDrawer(drawerViewModel)
            }
        }
    }
}

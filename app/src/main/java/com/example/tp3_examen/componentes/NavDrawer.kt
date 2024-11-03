package com.example.tp3_examen.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavDrawer() {

Column {

    DrawerHeader()

    Spacer(modifier = Modifier.height(24.dp))

    DrawerContent()
}



}
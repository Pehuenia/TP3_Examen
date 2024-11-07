package com.example.tp3_examen.components.drawermenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R
import com.example.tp3_examen.components.CircularIcon
import com.example.tp3_examen.components.switchbutton.SettingsCard

@Composable
fun NavDrawer() {
    var isNightMode by remember { mutableStateOf(false) }

    val drawerColors = if (isNightMode) {
        darkColorScheme()  // Usar el esquema de colores oscuro
    } else {
        lightColorScheme()  // Usar el esquema de colores claro
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        DrawerHeader()

        Spacer(modifier = Modifier.height(24.dp))

        DrawerContent()

        SettingsCard(
            text = stringResource(R.string.dark_mode),
            isChecked = isNightMode,
            onCheckedChange = { isNightMode = it },
            IconComponent = { CircularIcon() }

        )
    }


}
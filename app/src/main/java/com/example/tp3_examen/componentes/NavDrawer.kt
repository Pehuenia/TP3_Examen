package com.example.tp3_examen.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.CircularIcon
import com.example.tp3_examen.components1.switchbutton.SettingsCard
import com.example.tp3_examen.viewmodels.ThemeViewModel

@Composable
fun NavDrawer() {    //themeViewModel: ThemeViewModel
    var isChecked by remember { mutableStateOf(false) }

    Column {

        DrawerHeader()

        Spacer(modifier = Modifier.height(24.dp))

        DrawerContent()

        SettingsCard(
            text = "Dark Mode",
            isChecked = isChecked,
            onCheckedChange = { isChecked = it },
            IconComponent = { CircularIcon() }
        )
    }


}
package com.example.tp3_examen.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.CircularIcon
import com.example.tp3_examen.components1.switchbutton.SettingsCard
import com.example.tp3_examen.viewmodels.ThemeViewModel

@Composable
fun NavDrawer(themeViewModel: ThemeViewModel) {
val isChecked by themeViewModel.isNightMode.collectAsState()

    Column {

        DrawerHeader()

        Spacer(modifier = Modifier.height(24.dp))

        DrawerContent()

        SettingsCard(
            text = stringResource(R.string.dark_mode),
            isChecked = isChecked,
            onCheckedChange = { themeViewModel.toggleNightMode()},
            IconComponent = { CircularIcon() }

        )
    }


}
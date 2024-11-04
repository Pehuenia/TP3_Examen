package com.example.tp3_examen.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.tp3_examen.R
import com.example.tp3_examen.data.models.DrawerMenuItem
import com.example.tp3_examen.data.models.chevronIcon

@Composable
fun GetDrawerMenuItems(): List<DrawerMenuItem> {
    return listOf(
        DrawerMenuItem(stringResource(R.string.data_text), chevronIcon),
        DrawerMenuItem(stringResource(R.string.cvu_text), chevronIcon),
        DrawerMenuItem(stringResource(R.string.config_text), chevronIcon),
        DrawerMenuItem(stringResource(R.string.help_text), chevronIcon),
        DrawerMenuItem(stringResource(R.string.terms_text), chevronIcon),
        DrawerMenuItem(stringResource(R.string.close_session_text), chevronIcon)
    )
}

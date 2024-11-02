package com.example.tp3_examen.componentes.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.ChevronIcon
import com.example.tp3_examen.data.models.DrawerMenuItem


@Composable
fun DrawerItem(item: DrawerMenuItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "prueba son datos de prueba",
            style = MaterialTheme.typography.bodyMedium,
        )
        ChevronIcon()
    }
}




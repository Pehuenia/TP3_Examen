package com.example.tp3_examen.components

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.data.models.DrawerMenuItem


@Composable
fun DrawerItem(item: DrawerMenuItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /*onClick() */}
            .padding(vertical = 18.dp)
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            item.text,
            style = MaterialTheme.typography.bodyMedium
                .copy(
                    fontWeight = FontWeight.Bold
                ),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)

        )


        item.icon()
    }
}




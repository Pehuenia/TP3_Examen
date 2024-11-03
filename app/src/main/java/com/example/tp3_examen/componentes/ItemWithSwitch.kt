package com.example.tp3_examen.componentes

import SwitchComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.data.models.DrawerMenuItem

@Composable
fun DrawerItemWithSwitch(item: DrawerMenuItem) {
    val switchState = remember { mutableStateOf(false) }  //BORRAR CUANDO ESTÉ EL VIEW MODEL

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SwitchComponent(
            checked = switchState.value,
            onCheckedChange = { switchState.value = it }
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = item.text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}


/*
@Composable
fun BottomItemView(item: BottomItem, onSwitchChanged: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            tint = Color.Green
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = item.title, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = item.isSwitchOn,
            onCheckedChange = { onSwitchChanged(it) }
        )
    }
}

 */
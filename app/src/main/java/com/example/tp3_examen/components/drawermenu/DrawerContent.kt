package com.example.tp3_examen.components.drawermenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R
import com.example.tp3_examen.components.ItemsBackground
import com.example.tp3_examen.utilities.GetDrawerMenuItems


@Composable
fun DrawerContent() {
    val drawerMenuItems = GetDrawerMenuItems()

    ItemsBackground {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(8.dp)
                )
            // .clip(RoundedCornerShape(8.dp))

        ) {

            drawerMenuItems.forEachIndexed { index, item ->
                DrawerItem(item = item)
                if (index < drawerMenuItems.size - 1) {
                    HorizontalDivider(
                        //  thickness = 1.dp,
                        color = colorResource(R.color.gray_500),
                        modifier = Modifier.fillMaxWidth()


                    )
                }
            }
        }
    }
}

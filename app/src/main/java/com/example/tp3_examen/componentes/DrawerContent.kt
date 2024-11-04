package com.example.tp3_examen.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.ItemsBackground
import com.example.tp3_examen.utilities.GetDrawerMenuItems


@Composable
fun DrawerContent() {
    val drawerMenuItems = GetDrawerMenuItems()

    ItemsBackground {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )

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

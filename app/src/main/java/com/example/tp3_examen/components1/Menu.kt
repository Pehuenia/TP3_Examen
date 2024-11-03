package com.example.tp3_examen.components1

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun MainScreenWithBottomNavigation() {
    val menuItems = listOf(

    )
    BottomAppBar{
        NavigationBar{
            menuItems.forEach{item->
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {}

                )
            }

        }
    }
}
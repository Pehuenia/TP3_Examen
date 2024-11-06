package com.example.tp3_examen.components1

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.tp3_examen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    showArrow: Boolean,
    showCross: Boolean,
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit,
    showBackGround: Boolean
){

    var backgroundColor = Color(R.color.gray_100)
if(showBackGround){
    backgroundColor = Color(R.color.white)
}

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = colorResource(R.color.black)
        ),
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (showArrow) {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            }
        },
        actions = {
            if(showCross){
                IconButton(onClick = { onCloseClick() }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Localized description"
                    )
                }
            }

        },
    )
}
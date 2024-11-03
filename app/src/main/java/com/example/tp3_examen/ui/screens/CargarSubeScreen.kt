package com.example.tp3_examen.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.ButtonApp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CargarSubeScreen(
    textButton: String,
    //contenido : @Composable () -> Unit,
    //onclick : () -> Unit,


    ) {
    Scaffold(
       // modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(R.color.white),
                    titleContentColor = colorResource(R.color.black)
                ),
                title = {
                    Text(
                        "Cargar Sube",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Localized description"
                        )
                    }
                },
                //scrollBehavior = scrollBehavior,
            )
        },
    )
     { innerPadding ->
        CargarSubeContenido(Modifier.padding(innerPadding), textButton /*,onclik, contenido*/)

    }
}

    @SuppressLint("ResourceAsColor")
    @Composable
    fun CargarSubeContenido(
        modifier: Modifier,
        textButton: String,
        //onclick: () -> Unit,
        //contenido: @Composable () -> Unit //similar void no tiene retorno
    )
    {
     Box (
         modifier = modifier
             .fillMaxSize()
             .background(colorResource(R.color.gray_100))
     ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.Center
        ){
            ButtonApp(
                text = "Continuar",
                onClick = {})
        }

     }
    }











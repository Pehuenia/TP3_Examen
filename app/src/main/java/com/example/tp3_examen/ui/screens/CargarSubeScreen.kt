package com.example.tp3_examen.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.example.tp3_examen.R


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
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
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
     Box (modifier = modifier.fillMaxSize()){

         Button(
             onClick = {/*onclick()*/},
             colors = ButtonDefaults.buttonColors(Color(R.color.purple_900),),
             modifier = Modifier.align(Alignment.BottomCenter)) {

             Text("Hola")
         }
     }

    }

    //Componente correspondiente
    //Buttom Action un onclink




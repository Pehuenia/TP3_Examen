package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tp3_examen.R
import com.example.tp3_examen.components.ButtonApp
import com.example.tp3_examen.components.TopAppBar
import com.example.tp3_examen.components.modalsube.CardSube
import com.example.tp3_examen.navigation.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CargarSubeScreen(navController: NavHostController) {
    var showArrow by remember { mutableStateOf(true) }
    var showSubeCard by remember { mutableStateOf(true) }
    var buttonText by remember { mutableStateOf("Continuar") }
    var showSuccessMessage by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "Cargar SUBE",
                showArrow = showArrow,
                showCross = true,
                onBackClick = {
                    navController.popBackStack()
                },
                onCloseClick = {
                    navController.popBackStack()
                }

            )

        },
    ) { innerPadding ->
        CargarSubeContenido(
            modifier = Modifier.padding(innerPadding),
            textButton = buttonText,
            onClickContinuar = {
                if (buttonText == "Finalizar") {
                    // Navegar al HomeScreen cuando el texto del botón sea "Finalizar"
                    navController.navigate(Rutas.PagoDeServiciosScreen.ruta) {
                        //popUpTo(Rutas.PagoDeServiciosScreen.ruta) { inclusive = true }
                    }
                } else {
                    // Actualizar el estado para mostrar el mensaje de éxito
                    showArrow = false
                    showSubeCard = false
                    buttonText = "Finalizar"
                    showSuccessMessage = true
                }
            },
            showSubeCard = showSubeCard,
            showSuccessMessage = showSuccessMessage
        )
    }
}

@Composable
fun CargarSubeContenido(
    modifier: Modifier,
    textButton: String,
    onClickContinuar: () -> Unit,
    showSubeCard: Boolean,
    showSuccessMessage: Boolean
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.gray_100)),
        contentAlignment = Alignment.Center
    ) {
        if (showSuccessMessage) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween // Distribuye el espacio entre el contenido y el botón
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f) // Permite que esta columna ocupe el espacio disponible
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ok),
                        contentDescription = "Success",
                        modifier = Modifier.size(96.dp)
                    )
                    Text(
                        text = "Tu operación se ha realizado\n con éxito",
                        color = colorResource(id = R.color.black),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .wrapContentWidth()
                    )
                }

                ButtonApp(
                    text = textButton,
                    onClick = onClickContinuar
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.SpaceBetween // Esto coloca el contenido al principio y el botón al final
            ) {
                if (showSubeCard) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Verificá que la información sea correcta:",
                            color = colorResource(id = R.color.black),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 21.6.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .width(336.dp)
                                .padding(top = 50.dp, bottom = 50.dp, start = 12.dp)
                                .padding(12.dp)
                        )
                        CardSube()
                    }
                } else {
                    // Aquí puedes poner el nuevo componente que quieres mostrar
                    Text("Nuevo Componente")
                }
                ButtonApp(
                    text = textButton,
                    onClick = onClickContinuar
                )
            }
        }
    }
}
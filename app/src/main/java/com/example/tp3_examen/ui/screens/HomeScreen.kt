package com.example.tp3_examen.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp3_examen.R
import com.example.tp3_examen.components.Alert
import com.example.tp3_examen.components.CardActions
import com.example.tp3_examen.components.CardBalance
import com.example.tp3_examen.components.CreditCard
import com.example.tp3_examen.data.network.AuthRetrofit
import com.example.tp3_examen.data.shared.GetUserCase
import com.example.tp3_examen.data.shared.IGetUserService
import com.example.tp3_examen.utilities.AccessTimeManager
import com.example.tp3_examen.viewmodels.homeviewmodel.HomeViewModel
import com.example.tp3_examen.viewmodels.homeviewmodel.HomeViewModelFactory

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    var lastAccessTime by remember { mutableStateOf(AccessTimeManager.getLastAccessTime(context)) }
    var isFirstAccess by remember { mutableStateOf(AccessTimeManager.isFirstAccess(context)) }
    val getUserService = AuthRetrofit
    val getUserCase = GetUserCase(getUserService)
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(getUserCase)
    )
    val userDataState by homeViewModel.userDataState.observeAsState(
        HomeViewModel.UserDataState.Loading
    )

    LaunchedEffect(true) {
        homeViewModel.getUser()
    }

LaunchedEffect(Unit) {
    if (isFirstAccess) {
        lastAccessTime = context.getString(R.string.first_access)
        AccessTimeManager.setLastAccessTime(context)
        isFirstAccess = false
    } else {
        lastAccessTime = AccessTimeManager.getLastAccessTime(context)
        AccessTimeManager.setLastAccessTime(context)
    }
}
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.gray_100))
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            when (val state = userDataState) {
                is HomeViewModel.UserDataState.Loading -> {
                    Text(
                        text = "cargando",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 21.6.sp,
                            textAlign = TextAlign.Left,
                            color = colorResource(id = R.color.black)
                        )
                    )
                }
                is HomeViewModel.UserDataState.Error -> {
                    Text(
                        text = "error",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 21.6.sp,
                            textAlign = TextAlign.Left,
                            color = colorResource(id = R.color.black)
                        )
                    )
                }
                is HomeViewModel.UserDataState.Success -> {
                    Text(
                        text = stringResource(id = R.string.greeting) + " " + state.userName.firstname,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 21.6.sp,
                            textAlign = TextAlign.Left,
                            color = colorResource(id = R.color.black)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = R.string.last_access) + " $lastAccessTime" ,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 14.4.sp,
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.gray_900)
                )
            )
        }

        // cardNumber = "4957 7124 8154 2582" ,
        //expirationDate = "12/23"
        CreditCard()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.available_balance),
                color = colorResource(id = R.color.black),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 41.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = "$ 1.322,78", // le deberiamos pasar el monto
                color = colorResource(id = R.color.black),
                style = TextStyle(
                    fontSize = 44.sp,
                    lineHeight = 35.2.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }

        // La alerta solo se deberia mostras si tiene un prestamo activo por vencer
        val hasActiveLoan = true
        var showDialog by remember { mutableStateOf(false) }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Acción de Ítem") },
                text = { Text("Ejemplo de acción.") },
                confirmButton = {
                    TextButton(
                        onClick = { showDialog = false }
                    ) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDialog = false }
                    ) {
                        Text("Cancelar")
                    }
                }
            )
        }
        if (hasActiveLoan) {
            Alert(onClick = { showDialog = true })
        }

        CardActions()
    }
}
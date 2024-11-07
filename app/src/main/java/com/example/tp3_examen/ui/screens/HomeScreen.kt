package com.example.tp3_examen.ui.screens

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
import com.example.tp3_examen.components.CreditCard
import com.example.tp3_examen.data.network.AuthRetrofit
import com.example.tp3_examen.data.network.services.UserRepository
import com.example.tp3_examen.data.shared.GetUserCase
import com.example.tp3_examen.utilities.AccessTimeManager
import com.example.tp3_examen.viewmodels.homeviewmodel.HomeViewModel
import com.example.tp3_examen.viewmodels.homeviewmodel.HomeViewModelFactory
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModel
import com.example.tp3_examen.viewmodels.transactionsviewmodel.TransactionsViewModelFactory
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun HomeScreen() {
    // Context
    val context = LocalContext.current

    // Access Time Management
    var lastAccessTime by remember { mutableStateOf(AccessTimeManager.getLastAccessTime(context)) }
    var isFirstAccess by remember { mutableStateOf(AccessTimeManager.isFirstAccess(context)) }

    // User Service and ViewModel
    val getUserService = AuthRetrofit
    val getUserCase = GetUserCase(getUserService)
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(getUserCase)
    )
    val userDataState by homeViewModel.userDataState.observeAsState(
        HomeViewModel.UserDataState.Loading
    )

    // Fetch User Data
    LaunchedEffect(true) {
        homeViewModel.getUser()
    }

    // Update Access Time
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

    // Firestore and Transactions ViewModel
    val firestore = FirebaseFirestore.getInstance()
    val userRepository = UserRepository(firestore)
    val transactionsViewModel: TransactionsViewModel = viewModel(
        factory = TransactionsViewModelFactory(userRepository)
    )
    val transactionsState by transactionsViewModel.transactionsState.observeAsState(
        TransactionsViewModel.TransactionsState.Loading
    )

    // Fetch Bank Data
    LaunchedEffect(Unit) {
        transactionsViewModel.loadBankData()
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
            val textStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 21.6.sp,
                textAlign = TextAlign.Left,
                color = colorResource(id = R.color.black)
            )

            val greetingText = when (val state = userDataState) {
                is HomeViewModel.UserDataState.Loading -> stringResource(id = R.string.loading)
                is HomeViewModel.UserDataState.Error -> stringResource(id = R.string.error)
                is HomeViewModel.UserDataState.Success -> stringResource(id = R.string.greeting) + " " + state.userName.firstname
            }

            Text(
                text = greetingText,
                style = textStyle
            )


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

            val balanceTextStyle = TextStyle(
                fontSize = 44.sp,
                lineHeight = 35.2.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black)
            )

            val balanceText = when (val state = transactionsState) {
                is TransactionsViewModel.TransactionsState.Loading -> stringResource(id = R.string.loading)
                is TransactionsViewModel.TransactionsState.Error -> stringResource(id = R.string.error)
                is TransactionsViewModel.TransactionsState.Success -> "$ ${state.bankData.balance}"
            }

            Text(
                text = balanceText,
                style = balanceTextStyle
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
package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.components1.ButtonApp
import com.example.tp3_examen.components1.CardActions
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.components1.PruebaCard
import com.example.tp3_examen.components1.TransactionsList
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TP3_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 24.dp, horizontal = 0.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Mi Cuenta",
                                color = colorResource(id = R.color.black),
                                fontSize = 18.sp,
                                lineHeight = 21.6.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                textAlign = TextAlign.Center
                            )
                            PruebaCard()
                        }
                        Column(
                            modifier = Modifier.padding(0.dp),
                        ) {
                            TransactionsList()
                        }
                    }
                }
            }
        }
    }
}

package com.example.tp3_examen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.ui.screens.PruebasScreen
import com.example.tp3_examen.ui.theme.TP3_ExamenTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TP3_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .padding(top = 24.dp, end = 12.dp, bottom = 24.dp, start = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {

                        var usuario by remember { mutableStateOf(TextFieldValue("")) }
                        var password by remember { mutableStateOf(TextFieldValue("")) }

                        Input(
                            value = usuario,
                            onValueChange = { usuario = it },
                            label = "DNI o E-mail",
                            errorMessage = "Formato de email invalidoo",
                            isValid =  {Patterns.EMAIL_ADDRESS.matcher(it).matches()},
                        ) /*                        Input(
                            value = password,
                            onValueChange = { password = it },
                            label = "Contraseña",
                            errorMessage = "La contraseña debe tener al menos 4 caracteres",
                            isValid = { it.length >= 4 },
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done,
                            visualTransformation = PasswordVisualTransformation(),
                            isPassword = true
                        )
                        ButtonApp(text = "Ingresar", {})   */
                        PruebasScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP3_ExamenTheme {
        Greeting("Android")
    }
}
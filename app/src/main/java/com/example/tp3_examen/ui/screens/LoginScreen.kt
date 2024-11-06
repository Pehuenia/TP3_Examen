package com.example.tp3_examen.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.BackgroundLogin
import com.example.tp3_examen.components1.ButtonApp
import com.example.tp3_examen.components1.CircularIcon
import com.example.tp3_examen.components1.Input
import com.example.tp3_examen.viewmodels.LoginViewModel


@Composable
fun LoginScreen(viewModel: LoginViewModel) {

    var usuario by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    BackgroundLogin {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Column(
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(480.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .border(
                        0.dp,
                        colorResource(id = R.color.gray_500),
                        RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    )
                    .background(colorResource(id = R.color.gray_100))
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = colorResource(id = R.color.black),
                    style = typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        lineHeight = 22.4.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                Input(
                    value = usuario,
                    onValueChange = { usuario = it },
                    label = "DNI o E-mail",
                    errorMessage = stringResource(R.string.loginErrorUser),
                    isValid = { android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() },
                )
                Column(
                    Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Input(
                        value = password,
                        onValueChange = { password = it },
                        label = "Contraseña",
                        errorMessage = stringResource(id = R.string.loginErrorPassUser),
                        isValid = { it.length >= 4 },
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                        visualTransformation = PasswordVisualTransformation(),
                        isPassword = true
                    )
                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        color = colorResource(id = R.color.purple_900),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.4.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // Acción aca
                            },
                        textAlign = TextAlign.End
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularIcon(
                        backgroundColor = colorResource(id = R.color.gray_500),
                        icon = Icons.Default.Check,
                        iconTint = colorResource(id = R.color.white),
                        size = 24.dp
                    )
                    Text(
                        text = stringResource(R.string.loginScreen),
                        color = colorResource(id = R.color.black),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.4.sp
                        ),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                ButtonApp(text = "Ingresar") { viewModel.login(usuario.text, password.text) }
            }
        }

    }
}
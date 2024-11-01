package com.example.tp3_examen.components1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R


@Composable
fun Input(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    errorMessage: String,
    isValid: (String) -> Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isPassword: Boolean = false

) {
    var isError by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    val shadowColor = colorResource(id = R.color.gray_500)

    Column {
        TextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                if (it.text.isNotEmpty()) {
                    isError = !isValid(it.text)
                } else {
                    isError = false
                }
            },
            label = { Text(
                text = label,
                color = when {
                    value.text.isNotEmpty() || isFocused -> colorResource(id = R.color.gray_500)
                    else -> colorResource(id = R.color.gray_900)
                }
            ) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedContainerColor = colorResource(id = R.color.white),
                unfocusedContainerColor = colorResource(id = R.color.white),
                errorContainerColor = colorResource(id = R.color.white),
                focusedTextColor =  colorResource(id = R.color.black)
            ),
            isError = isError,
            trailingIcon = {
                if (isError && value.text.isNotEmpty()) {
                    Text(
                        text = "!",
                        color = colorResource(id = R.color.red_900),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                //Aca falta el agregado del icono para el password que tiene que ser gray_500 en todos los estados,
                //salvo cuando lo presionan que tiene que cambiar a otro icono en color purple_900
                /*
                if (isPassword) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Rounded.ShoppingCart else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = colorResource(id = R.color.purple_900)
                        )
                    }*/
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .border(
                    BorderStroke(
                        1.dp, when {
                            isError -> colorResource(id = R.color.red_900)
                            isFocused -> colorResource(id = R.color.purple_900)
                            else -> colorResource(id = R.color.gray_500)
                        }
                    ),
                    shape = RoundedCornerShape(3.dp)
                )
                .padding(bottom = 2.dp)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
                //Esto no me esta haciendo nada, no se que onda. es para dibujar el sombreado
                //cuando esta focuseado.
                /*.drawBehind {
                    if (isFocused) {
                        drawRoundRect(
                            color = shadowColor,
                            size = Size(size.width, size.height),
                            cornerRadius = CornerRadius(20.dp.toPx(), 20.dp.toPx()),
                            style = Stroke(width = 0f)
                        )
                    }
                },*/
            visualTransformation = visualTransformation,
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = colorResource(id = R.color.red_900),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 12.dp)
            )
        }
    }


}
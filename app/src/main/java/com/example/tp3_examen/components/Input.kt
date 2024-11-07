package com.example.tp3_examen.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

    Column(
        modifier = Modifier
            .animateContentSize()
    ) {

        TextField(
            value = value,
            singleLine = true,
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
                Row (verticalAlignment = Alignment.CenterVertically) {
                    if (isError && value.text.isNotEmpty()) {
                        Text(
                            text = "!",
                            color = colorResource(id = R.color.red_900),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                    }

                    if (isPassword) {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = if (passwordVisible) painterResource(id = R.drawable.ojo_tachado) else painterResource(id = R.drawable.ojo_abierto),
                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                tint = if (passwordVisible) colorResource(id = R.color.purple_900) else colorResource(id = R.color.gray_500),
                            )
                        }
                    }
                }
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
            visualTransformation = if (isPassword && !passwordVisible) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = colorResource(id = R.color.red_900),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 12.dp, top = 4.dp),
            )
        }
    }


}
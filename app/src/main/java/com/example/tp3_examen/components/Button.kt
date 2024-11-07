package com.example.tp3_examen.components

import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

@Composable
fun ButtonApp(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val colorDefault = colorResource(id = R.color.purple_900)
    val colorPressed = colorResource(id = R.color.green_900)
    val colorHover = colorResource(id = R.color.green_800)
    val colorDisabled = colorResource(id = R.color.gray_500)
    val interactionSource = remember { MutableInteractionSource() }
    val backgroundColor = remember { mutableStateOf(colorDefault) }

    LaunchedEffect(interactionSource, enabled) {
        if (enabled) {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> backgroundColor.value = colorPressed
                    is PressInteraction.Release -> backgroundColor.value = colorDefault
                    is HoverInteraction.Enter -> backgroundColor.value = colorHover
                    is HoverInteraction.Exit -> backgroundColor.value = colorDefault
                }
            }
        } else {
            backgroundColor.value = colorDisabled
        }
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(28.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor.value,
            contentColor = colorResource(id = R.color.white)
        ),
        enabled = enabled, // Establecer si el botón está habilitado o deshabilitado
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            softWrap = true
        )
    }
}

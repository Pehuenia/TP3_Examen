package com.example.tp3_examen.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/*
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TP3_ExamenTheme(
    darkTheme: Boolean,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
*/

 private val DarkColorScheme = darkColorScheme(
    primary = Purple80,               // Color principal
    secondary = PurpleGrey80,         // Color secundario
    tertiary = Pink80,                // Color terciario
    background = Purple80,            // Fondo de la app
    surface = PurpleGrey80,           // Fondo de superficies y bordes
    onBackground = Color.White,       // Color del texto en fondo oscuro
    onSurface = Color.White           // Color del texto en superficies oscuras
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,               // Color principal
    secondary = PurpleGrey40,         // Color secundario
    tertiary = Pink40,                // Color terciario
    background = Purple40,            // Fondo de la app
    surface = PurpleGrey40,           // Fondo de superficies y bordes
    onBackground = Color.Black,       // Color del texto en fondo claro
    onSurface = Color.Black           // Color del texto en superficies claras
)

@Composable
fun TP3_ExamenTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

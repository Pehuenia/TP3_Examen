package com.example.tp3_examen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

val manrope = FontFamily(
    Font(R.font.manrope_regular),
    Font(R.font.manrope_bold),
)

val Typography = Typography(
    displayLarge = TextStyle(fontFamily = manrope, fontSize = 34.sp),
    displayMedium = TextStyle(fontFamily = manrope, fontSize = 30.sp),
    displaySmall = TextStyle(fontFamily = manrope, fontSize = 26.sp),
    headlineLarge = TextStyle(fontFamily = manrope, fontSize = 24.sp),
    headlineMedium = TextStyle(fontFamily = manrope, fontSize = 20.sp),
    headlineSmall = TextStyle(fontFamily = manrope, fontSize = 18.sp),
    titleLarge = TextStyle(fontFamily = manrope, fontSize = 22.sp),
    titleMedium = TextStyle(fontFamily = manrope, fontSize = 20.sp),
    titleSmall = TextStyle(fontFamily = manrope, fontSize = 18.sp),
    bodyLarge = TextStyle(fontFamily = manrope, fontSize = 16.sp),
    bodyMedium = TextStyle(fontFamily = manrope, fontSize = 14.sp),
    bodySmall = TextStyle(fontFamily = manrope, fontSize = 12.sp),
    labelLarge = TextStyle(fontFamily = manrope, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = manrope, fontSize = 12.sp),
    labelSmall = TextStyle(fontFamily = manrope, fontSize = 10.sp)
)

// Set of Material typography styles to start with
/*val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )*/
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */

package com.example.mikocompany.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mikocompany.R

val baseline = Typography()

val zk = FontFamily(
    Font(R.font.zk, FontWeight.Normal)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = baseline.displayLarge.copy(fontFamily = zk),
    displayMedium = baseline.displayMedium.copy(fontFamily = zk),
    displaySmall = baseline.displaySmall.copy(fontFamily = zk),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = zk),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = zk),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = zk),
    titleLarge = baseline.titleLarge.copy(fontFamily = zk),
    titleMedium = baseline.titleMedium.copy(fontFamily = zk),
    titleSmall = baseline.titleSmall.copy(fontFamily = zk),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = zk),
    bodySmall = baseline.bodySmall.copy(fontFamily = zk),
    labelLarge = baseline.labelLarge.copy(fontFamily = zk),
    labelMedium = baseline.labelMedium.copy(fontFamily = zk),
    labelSmall = baseline.labelSmall.copy(fontFamily = zk)
)


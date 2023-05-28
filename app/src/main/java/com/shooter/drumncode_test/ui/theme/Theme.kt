package com.shooter.drumncode_test.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = ThemePrimary,
    secondary = ThemeSecondary,
    background = ThemeBackground,
    onSecondary = ThemeOnSecondary,
    onBackground = ThemeOnBackground
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
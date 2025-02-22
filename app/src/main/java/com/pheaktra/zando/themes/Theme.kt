package com.pheaktra.zando.themes

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.Color
import com.pheaktra.zando.viewmodel.ThemeViewModel

// Define color schemes
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun ZandoTheme(viewModel: ThemeViewModel = viewModel(), content: @Composable () -> Unit) {
    // Collect dark mode state from the ThemeViewModel
    val isDarkMode = viewModel.isDarkMode.collectAsState().value

    // Choose the color scheme based on the dark mode state
    val colors = if (isDarkMode) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography, // This is correct, no change needed
        content = content
    )
}

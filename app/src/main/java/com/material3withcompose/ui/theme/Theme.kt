package com.material3withcompose.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColorScheme(
    primary = Rose80,
    onPrimary = Rose20,
    primaryContainer = Rose30,
    onPrimaryContainer = Rose90,
    inversePrimary = Rose40,
    secondary = DarkRose80,
    onSecondary = DarkRose20,
    secondaryContainer = DarkRose30,
    onSecondaryContainer = DarkRose90,
    tertiary = Violet80,
    onTertiary = Violet20,
    tertiaryContainer = Violet30,
    onTertiaryContainer = Violet90,
    error = Red80,
    onError = Red20,
    errorContainer = Red40,
    onErrorContainer = Red90,
    background = Grey10,
    onBackground = Grey90,
    surface = RoseGrey30,
    onSurface = RoseGrey80,
    inverseSurface = Grey90,
    inverseOnSurface = Grey10,
    surfaceVariant = RoseGrey30,
    onSurfaceVariant = RoseGrey80,
    outline = RoseGrey80
)

private val LightColorPalette = lightColorScheme(
    primary = Rose40,
    onPrimary = Color.White,
    primaryContainer = Rose90,
    onPrimaryContainer = Rose10,
    inversePrimary = Rose80,
    secondary = DarkRose40,
    onSecondary = Color.White,
    secondaryContainer = DarkRose90,
    onSecondaryContainer = DarkRose10,
    tertiary = Violet40,
    onTertiary = Color.White,
    tertiaryContainer = Violet90,
    onTertiaryContainer = Violet10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Grey99,
    onBackground = Grey10,
    surface = RoseGrey90,
    onSurface = RoseGrey30,
    inverseSurface = Grey20,
    inverseOnSurface = Grey95,
    surfaceVariant = RoseGrey90,
    onSurfaceVariant = RoseGrey30,
    outline = RoseGrey50
)

@Composable
fun Material3WithComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val useDynamicColors = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors = when {
        useDynamicColors && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        useDynamicColors && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
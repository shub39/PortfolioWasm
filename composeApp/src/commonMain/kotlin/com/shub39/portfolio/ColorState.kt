package com.shub39.portfolio

import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import kotlin.random.Random

data class ColorState(
    val isDark: Boolean = true,
    val style: PaletteStyle = PaletteStyle.Expressive,
    val seedColor: Color = Color(
        Random.nextFloat(),
        Random.nextFloat(),
        Random.nextFloat()
    )
)

fun ColorState.randomizeSeed(): ColorState = copy(
    seedColor = Color(
        Random.nextFloat(),
        Random.nextFloat(),
        Random.nextFloat()
    )
)
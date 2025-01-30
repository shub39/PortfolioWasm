package com.shub39.portfolio

import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle

data class ColorState(
    val isDark: Boolean = true,
    val isAmoled: Boolean = false,
    val style: PaletteStyle = PaletteStyle.TonalSpot,
    val seedColor: Color = Color.Red
)

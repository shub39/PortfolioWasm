package com.shub39.portfolio

import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import kotlin.random.Random

data class ColorState(
    val isDark: Boolean = true,
    val isAmoled: Boolean = false,
    val style: PaletteStyle = PaletteStyle.TonalSpot,
    val seedColor: Color = randomColor()
) {
    companion object {
        fun randomColor(): Color {
            return Color(
                red = Random.nextFloat(),
                green = Random.nextFloat(),
                blue = Random.nextFloat(),
                alpha = 1f
            )
        }
    }
}

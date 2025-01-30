package com.shub39.portfolio.navheader

import androidx.compose.ui.graphics.Color

fun Color.toRgbString(): String {
    return "rgb(${(red * 255).toInt()}, ${(green * 255).toInt()}, ${(blue * 255).toInt()})"
}

fun Color.toHslString(): String {
    val r = red
    val g = green
    val b = blue

    val max = maxOf(r, g, b)
    val min = minOf(r, g, b)
    val delta = max - min

    var h = 0f
    var s = 0f
    val l = (max + min) / 2

    if (delta != 0f) {
        s = if (l > 0.5f) delta / (2f - max - min) else delta / (max + min)

        h = when (max) {
            r -> (g - b) / delta + if (g < b) 6f else 0f
            g -> (b - r) / delta + 2f
            b -> (r - g) / delta + 4f
            else -> 0f
        }

        h *= 60f
    }

    return "hsl(${h.toInt()}, ${(s * 100).toInt()}%, ${(l * 100).toInt()}%)"
}
package com.shub39.portfolio

enum class WindowSize {
    Compact,
    Medium,
    Expanded;
}

fun getWindowSize(width: Int): WindowSize {
    return when (width) {
        in 0..599 -> WindowSize.Compact
        in 600..839 -> WindowSize.Medium
        else -> WindowSize.Expanded
    }
}
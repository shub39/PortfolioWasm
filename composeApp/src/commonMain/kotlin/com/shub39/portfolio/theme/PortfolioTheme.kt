package com.shub39.portfolio.theme

import androidx.compose.runtime.Composable
import com.materialkolor.DynamicMaterialTheme
import com.shub39.portfolio.ColorState

@Composable
fun PortfolioTheme(
    state: ColorState,
    content: @Composable () -> Unit
) {
    DynamicMaterialTheme(
        seedColor = state.seedColor,
        useDarkTheme = state.isDark,
        withAmoled = state.isAmoled,
        style = state.style,
        typography = provideTypography(1f),
        animate = true,
        content = content
    )
}
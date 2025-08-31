package com.shub39.portfolio.data

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDestination<T>(
    val icon: ImageVector,
    val label: String,
    val route: T
)
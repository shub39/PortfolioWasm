package com.shub39.portfolio.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PageFill(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) { content() }
}
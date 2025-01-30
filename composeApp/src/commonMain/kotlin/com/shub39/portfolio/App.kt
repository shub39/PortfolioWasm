package com.shub39.portfolio

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.PaletteStyle
import com.shub39.portfolio.navheader.NavHeader
import com.shub39.portfolio.theme.provideTypography

@Composable
internal fun App() {
    var isDark by remember { mutableStateOf(true) }
    var seedColor by remember { mutableStateOf(Color.Red) }
    var style by remember { mutableStateOf(PaletteStyle.TonalSpot) }

    DynamicMaterialTheme(
        seedColor = seedColor,
        useDarkTheme = isDark,
        style = style,
        typography = provideTypography(1f),
        animate = true
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .widthIn(max = 700.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val listState = rememberLazyListState()
                    val coroutineScope = rememberCoroutineScope()

                    Spacer(modifier = Modifier.padding(32.dp))

                    NavHeader(
                        isDark = isDark,
                        seedColor = seedColor,
                        palette = style,
                        changeSeedColor = { seedColor = it },
                        changeTheme = { isDark = it },
                        changePalette = { style = it }
                    )

                    LazyColumn (
                        modifier = Modifier.fillMaxSize(),
                        state = listState
                    ) {
                        item {  }
                    }
                }
            }
        }
    }
}


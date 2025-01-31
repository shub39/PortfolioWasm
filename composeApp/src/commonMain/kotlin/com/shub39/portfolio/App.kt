package com.shub39.portfolio

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.materialkolor.DynamicMaterialTheme
import com.shub39.portfolio.colorPicker.ColorPicker
import com.shub39.portfolio.intro.Intro
import com.shub39.portfolio.navheader.NavHeader
import com.shub39.portfolio.projects.Projects
import com.shub39.portfolio.theme.provideTypography

@Composable
internal fun App() {
    var colorState by remember { mutableStateOf(ColorState()) }

    val listState = rememberLazyListState()

    val currentItemIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }

    val topPadding by animateDpAsState(
        targetValue = when {
            currentItemIndex > 0 -> 16.dp
            else -> 32.dp
        }
    )

    DynamicMaterialTheme(
        seedColor = colorState.seedColor,
        useDarkTheme = colorState.isDark,
        withAmoled = colorState.isAmoled,
        style = colorState.style,
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
                        .padding(top = topPadding, start = 16.dp, end = 16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    NavHeader(
                        state = colorState,
                        editState = { colorState = it }
                    )

                    LazyColumn (
                        modifier = Modifier.fillMaxSize(),
                        state = listState,
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        item {
                            Intro(
                                isDark = colorState.isDark
                            )
                        }

                        item {
                            Projects()
                        }

                        item {
                            ColorPicker()
                        }

                        item { Spacer(modifier = Modifier.padding(60.dp)) }
                    }
                }
            }
        }
    }
}


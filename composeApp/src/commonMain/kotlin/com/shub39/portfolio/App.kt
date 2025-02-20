package com.shub39.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.color.ColorCopy
import com.shub39.portfolio.color.ColorPicker
import com.shub39.portfolio.intro.Intro
import com.shub39.portfolio.nav.NavRow
import com.shub39.portfolio.theme.PortfolioTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun App() {
    var colorState by remember { mutableStateOf(ColorState()) }
    val size = LocalWindowInfo.current.containerSize
    val windowSize = getWindowSize(size.width)

    val listState = rememberLazyListState()

    PortfolioTheme(
       state = colorState
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                            MaterialTheme.colorScheme.tertiary
                        )
                    )
                )
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    LazyColumn(
                        state = listState,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            Intro(
                                modifier = Modifier
                                    .size(size.width.dp, size.height.dp)
                                    .padding(32.dp)
                                    .fillMaxWidth(),
                                windowSize = windowSize
                            )
                        }

                        item {
                            ColorPicker(
                                state = colorState,
                                editState = { colorState = it },
                                modifier = Modifier
                                    .size(size.width.dp, size.height.dp)
                                    .padding(16.dp)
                            )
                        }

                        item {
                            ColorCopy(
                                modifier = Modifier
                                    .size(size.width.dp, size.height.dp)
                                    .padding(16.dp)
                            )
                        }
                    }
                }

                NavRow(
                    listState = listState,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}


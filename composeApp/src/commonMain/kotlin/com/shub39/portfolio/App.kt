package com.shub39.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.components.BackgroundShapes
import com.shub39.portfolio.pages.AboutPage
import com.shub39.portfolio.pages.AppsPage
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.pages.ProjectsPage
import com.shub39.portfolio.util.PortfolioTheme
import kotlinx.coroutines.launch

@Composable
internal fun App() {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val currentIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }
    var colorState by remember { mutableStateOf(ColorState()) }

    PortfolioTheme(
        state = colorState
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceDim)
        ) {
            Surface(
                color = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    BackgroundShapes(
                        visible = currentIndex == 0
                    )

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        state = listState
                    ) {
                        item {
                            HomePage(
                                modifier = Modifier
                                    .height(this@BoxWithConstraints.maxHeight)
                                    .fillMaxWidth(),
                                onScroll = {
                                    coroutineScope.launch { listState.animateScrollToItem(it) }
                                },
                                onToggleDarkMode = { colorState = colorState.copy(isDark = !colorState.isDark) }
                            )
                        }

                        item {
                            AppsPage(
                                modifier = Modifier
                                    .heightIn(min = this@BoxWithConstraints.maxHeight)
                                    .widthIn(max = 1200.dp)
                            )
                        }

                        item {
                            ProjectsPage(
                                modifier = Modifier
                                    .heightIn(min = this@BoxWithConstraints.maxHeight)
                                    .widthIn(max = 1200.dp)
                            )
                        }

                        item {
                            AboutPage(
                                modifier = Modifier
                                    .heightIn(min = this@BoxWithConstraints.maxHeight)
                                    .widthIn(max = 1200.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
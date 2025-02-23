package com.shub39.portfolio

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mikepenz.hypnoticcanvas.shaderBackground
import com.mikepenz.hypnoticcanvas.shaders.MeshGradient
import com.shub39.portfolio.color.ColorPicker
import com.shub39.portfolio.intro.Intro
import com.shub39.portfolio.nav.NavRow
import com.shub39.portfolio.projects.Projects
import com.shub39.portfolio.theme.PortfolioTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeSource

@Composable
internal fun App() {
    var colorState by remember { mutableStateOf(ColorState()) }
    var section by remember { mutableStateOf(Sections.Home) }
    val navHazeState = remember { HazeState() }

    var hypnotic by remember { mutableStateOf(true) }

    PortfolioTheme(
        state = colorState
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .let {
                    if (hypnotic) {
                        it.shaderBackground(
                            MeshGradient(
                                colors = arrayOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.secondary,
                                    MaterialTheme.colorScheme.tertiary
                                )
                            )
                        )
                    } else {
                        it.background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.secondary,
                                    MaterialTheme.colorScheme.tertiary
                                )
                            )
                        )
                    }
                }
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AnimatedContent(
                    targetState = section,
                    modifier = Modifier.hazeSource(navHazeState)
                ) { sections ->
                    when (sections) {
                        Sections.Home -> Intro(
                            modifier = Modifier
                                .padding(32.dp)
                                .fillMaxSize()
                        )

                        Sections.ColorPicker -> ColorPicker(
                            state = colorState,
                            editState = { colorState = it },
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                        )

                        Sections.Projects -> Projects(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                        )
                    }
                }

                NavRow(
                    sections = section,
                    hypnotic = hypnotic,
                    onHypnoticChange = { hypnotic = !hypnotic },
                    hazeState = navHazeState,
                    onChange = { section = it },
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}


package com.shub39.portfolio.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun Intro(
    isDark: Boolean
) {
    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))

    Card(
        shape = MaterialTheme.shapes.extraLarge,
        modifier = Modifier.border(
            width = 3.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.extraLarge
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = if (isDark) {
                                listOf(
                                    MaterialTheme.colorScheme.inverseSurface,
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.inversePrimary
                                )
                            } else {
                                listOf(
                                    MaterialTheme.colorScheme.background,
                                    MaterialTheme.colorScheme.primaryContainer,
                                    MaterialTheme.colorScheme.secondaryContainer
                                )
                            }
                        ),
                        shape = MaterialTheme.shapes.large
                    )
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "Hello! I'm Shubham",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Beginner Android Dev and Linux Nerd from India",
                style = MaterialTheme.typography.titleMedium,
                fontFamily = jetbrains
            )

            SocialLinksRow()
        }
    }
}
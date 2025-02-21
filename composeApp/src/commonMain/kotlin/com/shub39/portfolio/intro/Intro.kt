package com.shub39.portfolio.intro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun Intro(
    modifier: Modifier = Modifier
) {
    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))
    val brush = Brush.verticalGradient(
        listOf(
            MaterialTheme.colorScheme.onTertiary,
            MaterialTheme.colorScheme.onSecondary,
            MaterialTheme.colorScheme.onPrimary
        )
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "{shub39}",
            fontWeight = FontWeight.Bold,
            fontFamily = jetbrains,
            style = MaterialTheme.typography.displayMedium.copy(
                brush = brush
            ),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Beginner Android dev and Linux Nerd from India",
            fontFamily = jetbrains,
            style = MaterialTheme.typography.titleLarge.copy(
                brush = brush
            ),
            textAlign = TextAlign.Center
        )

        SocialLinksRow()
    }
}
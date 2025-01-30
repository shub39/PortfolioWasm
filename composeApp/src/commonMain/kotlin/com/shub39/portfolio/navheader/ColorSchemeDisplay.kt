package com.shub39.portfolio.navheader

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorSchemeDisplay(
    onClick: (Color) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val colors = listOf(
        "Primary" to colorScheme.primary,
        "On Primary" to colorScheme.onPrimary,
        "Primary Container" to colorScheme.primaryContainer,
        "On Primary Container" to colorScheme.onPrimaryContainer,
        "Secondary" to colorScheme.secondary,
        "On Secondary" to colorScheme.onSecondary,
        "Secondary Container" to colorScheme.secondaryContainer,
        "On Secondary Container" to colorScheme.onSecondaryContainer,
        "Tertiary" to colorScheme.tertiary,
        "On Tertiary" to colorScheme.onTertiary,
        "Tertiary Container" to colorScheme.tertiaryContainer,
        "On Tertiary Container" to colorScheme.onTertiaryContainer,
        "Error" to colorScheme.error,
        "On Error" to colorScheme.onError,
        "Error Container" to colorScheme.errorContainer,
        "On Error Container" to colorScheme.onErrorContainer,
        "Background" to colorScheme.background,
        "On Background" to colorScheme.onBackground,
        "Surface" to colorScheme.surface,
        "On Surface" to colorScheme.onSurface,
        "Surface Variant" to colorScheme.surfaceVariant,
        "On Surface Variant" to colorScheme.onSurfaceVariant,
        "Outline" to colorScheme.outline
    )

    Column(modifier = Modifier.padding(16.dp)) {
        colors.chunked(2).forEach { rowColors ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                rowColors.forEach { (name, color) ->
                    ColorBox(
                        name = name,
                        color = color,
                        modifier = Modifier.weight(1f),
                        onClick = onClick
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun ColorBox(
    name: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(color, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .pointerHoverIcon(
                icon = PointerIcon.Hand
            )
            .clickable { onClick(color) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            color = if (color.luminance() > 0.5f) Color.Black else Color.White,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}

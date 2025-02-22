package com.shub39.portfolio.color

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.components.ExpandingIconButton
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Palette

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ColorSchemeDisplay(
    tooltip: (Color) -> String,
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
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            colors.forEach { (name, color) ->
                ExpandingIconButton(
                    modifier = Modifier.padding(4.dp),
                    onClick = { onClick(color) },
                    tooltip = "$name\n${tooltip(color)}"
                ) {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Palette,
                        contentDescription = name,
                        tint = color
                    )
                }
            }
        }
    }
}
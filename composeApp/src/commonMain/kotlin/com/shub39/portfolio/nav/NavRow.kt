package com.shub39.portfolio.nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.Sections
import com.shub39.portfolio.components.ExpandingIconButton
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.PaintRoller
import compose.icons.fontawesomeicons.solid.Tools
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.hazeEffect

@Composable
fun NavRow(
    sections: Sections,
    hazeState: HazeState,
    onChange: (Sections) -> Unit,
    modifier: Modifier = Modifier
) {
    val cardStyle = HazeStyle(
        backgroundColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
        tints = listOf(),
        blurRadius = 12.dp,
        noiseFactor = HazeDefaults.noiseFactor
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .clip(CircleShape)
                .hazeEffect(hazeState, cardStyle)
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Sections.entries.forEach { secs ->
                    ExpandingIconButton(
                        onClick = {
                            onChange(secs)
                        },
                        tooltip = when (secs) {
                            Sections.Home -> "Home"
                            Sections.Projects -> "Projects"
                            Sections.ColorPicker -> "Color Picker"
                        },
                        colors = if (sections != secs) IconButtonDefaults.filledTonalIconButtonColors() else IconButtonDefaults.filledIconButtonColors()
                    ) {
                        Icon(
                            imageVector = when (secs) {
                                Sections.Home -> FontAwesomeIcons.Solid.Home
                                Sections.Projects -> FontAwesomeIcons.Solid.Tools
                                Sections.ColorPicker -> FontAwesomeIcons.Solid.PaintRoller
                            },
                            contentDescription = "Change Palette",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}
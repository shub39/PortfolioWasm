package com.shub39.portfolio.nav

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.Sections
import com.shub39.portfolio.components.ExpandingIconButton
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Clipboard
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.PaintRoller
import compose.icons.fontawesomeicons.solid.Tools

@Composable
fun NavRow(
    sections: Sections,
    onChange: (Sections) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
            )
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
                            Sections.CopyColor -> "Copy Colors"
                        },
                        colors = if (sections != secs) IconButtonDefaults.filledTonalIconButtonColors() else IconButtonDefaults.filledIconButtonColors()
                    ) {
                        Icon(
                            imageVector = when (secs) {
                                Sections.Home -> FontAwesomeIcons.Solid.Home
                                Sections.Projects -> FontAwesomeIcons.Solid.Tools
                                Sections.ColorPicker -> FontAwesomeIcons.Solid.PaintRoller
                                Sections.CopyColor -> FontAwesomeIcons.Solid.Clipboard
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
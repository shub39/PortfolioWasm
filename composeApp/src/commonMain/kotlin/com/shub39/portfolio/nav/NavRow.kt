package com.shub39.portfolio.nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.components.ExpandingIconButton
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Clipboard
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.PaintRoller
import kotlinx.coroutines.launch

@Composable
fun NavRow(
    listState: LazyListState,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    val currentIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }

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
                listOf(0, 1, 2).forEach { index ->
                    ExpandingIconButton(
                        onClick = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(index)
                            }
                        },
                        tooltip = when (index) {
                            0 -> "Home"
                            1 -> "Color Picker"
                            else -> "Copy Colors"
                        },
                        colors = if (currentIndex != index) IconButtonDefaults.filledTonalIconButtonColors() else IconButtonDefaults.filledIconButtonColors()
                    ) {
                        Icon(
                            imageVector = when (index) {
                                0 -> FontAwesomeIcons.Solid.Home
                                1 -> FontAwesomeIcons.Solid.PaintRoller
                                else -> FontAwesomeIcons.Solid.Clipboard
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
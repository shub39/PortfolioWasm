package com.shub39.portfolio.pages

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.pages.data.NavigateInfo
import com.shub39.portfolio.pages.data.SOCIAL_LINKS
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.solid.ArrowUp
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Moon
import compose.icons.fontawesomeicons.solid.Mouse
import compose.icons.fontawesomeicons.solid.Palette
import compose.icons.fontawesomeicons.solid.Sun
import compose.icons.fontawesomeicons.solid.Tools

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
    onScroll: (Int) -> Unit,
    onToggleDarkMode: () -> Unit,
    onRandomizeSeed: () -> Unit
) = PageFill(modifier = modifier) {
    val uriHandler = LocalUriHandler.current

    Row(
        modifier = Modifier
            .padding(32.dp)
            .align(Alignment.TopEnd)
    ) {
        FilledTonalIconButton(
            onClick = onRandomizeSeed,
            shapes = IconButtonShapes(
                pressedShape = MaterialTheme.shapes.extraLarge,
                shape = MaterialTheme.shapes.medium
            )
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Solid.Palette,
                contentDescription = "Toggle Dark Mode",
                modifier = Modifier.size(24.dp)
            )
        }

        FilledTonalIconButton(
            onClick = onToggleDarkMode,
            shapes = IconButtonShapes(
                pressedShape = MaterialTheme.shapes.extraLarge,
                shape = MaterialTheme.shapes.medium
            )
        ) {
            Icon(
                imageVector = if (darkTheme) FontAwesomeIcons.Solid.Sun else FontAwesomeIcons.Solid.Moon,
                contentDescription = "Toggle Dark Mode",
                modifier = Modifier.size(24.dp)
            )
        }
    }

    Button(
        onClick = { onScroll(1) },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        shapes = ButtonShapes(
            pressedShape = MaterialTheme.shapes.extraLarge,
            shape = MaterialTheme.shapes.medium
        ),
        modifier = Modifier
            .padding(bottom = 32.dp)
            .align(Alignment.BottomCenter)
    ) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Mouse,
            contentDescription = "Scroll",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Icon(
            imageVector = FontAwesomeIcons.Solid.ArrowUp,
            contentDescription = "Scroll",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text("Scroll")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.extraExtraLarge,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryFixed,
                contentColor = MaterialTheme.colorScheme.onSecondaryFixed
            )
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Shubham Gorai",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "Android dev and Linux nerd from India",
                    style = MaterialTheme.typography.titleLargeEmphasized,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))


                FlowRow(
                    modifier = Modifier
                        .widthIn(max = 500.dp),
                    horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    SOCIAL_LINKS.forEachIndexed { index, buttonInfo ->
                        val interactionSource = remember { MutableInteractionSource() }
                        val isHovered by interactionSource.collectIsHoveredAsState()

                        ToggleButton(
                            checked = isHovered,
                            onCheckedChange = { uriHandler.openUri(buttonInfo.link) },
                            interactionSource = interactionSource,
                            colors = ToggleButtonDefaults.tonalToggleButtonColors(),
                            shapes = when (index) {
                                0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                                SOCIAL_LINKS.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                                else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                            }
                        ) {
                            Icon(
                                imageVector = buttonInfo.imageVector,
                                contentDescription = buttonInfo.title,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }

        FlowRow(
            modifier = Modifier
                .padding(8.dp)
                .widthIn(max = 800.dp),
            horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            val destinations = listOf(
                NavigateInfo(FontAwesomeIcons.Brands.Android, 1, "Apps"),
                NavigateInfo(FontAwesomeIcons.Solid.Tools, 2, "Projects"),
                NavigateInfo(FontAwesomeIcons.Solid.Male, 3, "About")
            )

            destinations.forEachIndexed { index, info ->
                val interactionSource = remember { MutableInteractionSource() }
                val isHovered by interactionSource.collectIsHoveredAsState()

                ToggleButton(
                    checked = isHovered,
                    onCheckedChange = { onScroll(info.index) },
                    interactionSource = interactionSource,
                    colors = ToggleButtonDefaults.toggleButtonColors(

                    ),
                    shapes = when (index) {
                        0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                        destinations.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                    }
                ) {
                    Icon(
                        imageVector = info.imageVector,
                        contentDescription = info.title,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.padding(4.dp))

                    Text(info.title)
                }
            }
        }
    }
}
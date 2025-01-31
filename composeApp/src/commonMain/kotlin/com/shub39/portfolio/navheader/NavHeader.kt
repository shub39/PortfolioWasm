package com.shub39.portfolio.navheader

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.materialkolor.PaletteStyle
import com.shub39.portfolio.ColorState
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.solid.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavHeader(
    state: ColorState,
    editState: (ColorState) -> Unit
) {
    var paletteSelectDialog by remember { mutableStateOf(false) }
    var siteInfoDialog by remember { mutableStateOf(false) }

    val cardColors = CardDefaults.cardColors()

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                editState(
                    state.copy(
                        isDark = !state.isDark
                    )
                )
            }
        ) {
            Icon(
                imageVector = if (state.isDark) {
                    FontAwesomeIcons.Solid.Moon
                } else {
                    FontAwesomeIcons.Solid.Sun
                },
                contentDescription = "Toggle Theme",
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = {
                paletteSelectDialog = true
            }
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Solid.PaintBrush,
                contentDescription = "Change Palette",
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = { siteInfoDialog = true }
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Solid.Info,
                contentDescription = "Info",
                modifier = Modifier.size(24.dp)
            )
        }
    }

    if (siteInfoDialog) {
        val uriHandler = LocalUriHandler.current

        Dialog(
            onDismissRequest = { siteInfoDialog = false }
        ) {
            Card(
                modifier = Modifier.padding(vertical = 32.dp),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Source"
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Link to the Site's Github Repo"
                                )
                            },
                            trailingContent = {
                                IconButton(
                                    onClick = {
                                        uriHandler.openUri("https://github.com/shub39/PortfolioWasm")
                                    }
                                ) {
                                    Icon(
                                        imageVector = FontAwesomeIcons.Brands.Github,
                                        contentDescription = "Github"
                                    )
                                }
                            },
                            modifier = Modifier.clip(MaterialTheme.shapes.large),
                            colors = ListItemDefaults.colors(
                                containerColor = cardColors.containerColor,
                                headlineColor = cardColors.contentColor,
                                trailingIconColor = cardColors.contentColor
                            )
                        )
                    }

                    item {
                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "MaterialKolor"
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Library used for generating Color Palettes"
                                )
                            },
                            trailingContent = {
                                IconButton(
                                    onClick = {
                                        uriHandler.openUri("https://github.com/jordond/MaterialKolor")
                                    }
                                ) {
                                    Icon(
                                        imageVector = FontAwesomeIcons.Brands.Github,
                                        contentDescription = "Github"
                                    )
                                }
                            },
                            modifier = Modifier.clip(MaterialTheme.shapes.large),
                            colors = ListItemDefaults.colors(
                                containerColor = cardColors.containerColor,
                                headlineColor = cardColors.contentColor,
                                trailingIconColor = cardColors.contentColor
                            )
                        )
                    }

                    item {
                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Colorpicker Compose"
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Library used for the color picker"
                                )
                            },
                            trailingContent = {
                                IconButton(
                                    onClick = {
                                        uriHandler.openUri("https://github.com/skydoves/colorpicker-compose")
                                    }
                                ) {
                                    Icon(
                                        imageVector = FontAwesomeIcons.Brands.Github,
                                        contentDescription = "Github"
                                    )
                                }
                            },
                            modifier = Modifier.clip(MaterialTheme.shapes.large),
                            colors = ListItemDefaults.colors(
                                containerColor = cardColors.containerColor,
                                headlineColor = cardColors.contentColor,
                                trailingIconColor = cardColors.contentColor
                            )
                        )
                    }
                }
            }
        }
    }

    if (paletteSelectDialog) {
        val controller = rememberColorPickerController()

        Dialog(
            onDismissRequest = { paletteSelectDialog = false }
        ) {
            Card(
                modifier = Modifier.padding(vertical = 32.dp),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Dark Mode",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Toggle Dark Mode"
                                )
                            },
                            trailingContent = {
                                Switch(
                                    checked = state.isDark,
                                    onCheckedChange = {
                                        editState(
                                            state.copy(
                                                isDark = !state.isDark
                                            )
                                        )
                                    }
                                )
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = cardColors.containerColor,
                                headlineColor = cardColors.contentColor
                            )
                        )
                    }

                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ListItem(
                                headlineContent = {
                                    Text(
                                        text = "Select Palette Style",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                },
                                supportingContent = {
                                    Text(
                                        text = "Select the variant of palette generated from seed color"
                                    )
                                },
                                colors = ListItemDefaults.colors(
                                    containerColor = cardColors.containerColor,
                                    headlineColor = cardColors.contentColor
                                )
                            )

                            PaletteStyle.entries.toList().chunked(3).forEach { triplet ->
                                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                    triplet.forEach {
                                        InputChip(
                                            selected = state.style == it,
                                            onClick = {
                                                editState(
                                                    state.copy(
                                                        style = it
                                                    )
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = it.name
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }

                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ListItem(
                                headlineContent = {
                                    Text(
                                        text = "Select Seed Color",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                },
                                supportingContent = {
                                    Text(
                                        text = "Click on the Check Icon to generate palette"
                                    )
                                },
                                trailingContent = {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        AlphaTile(
                                            modifier = Modifier
                                                .size(50.dp)
                                                .padding(10.dp)
                                                .clip(RoundedCornerShape(20.dp)),
                                            controller = controller
                                        )

                                        IconButton(
                                            onClick = {
                                                editState(
                                                    state.copy(
                                                        seedColor = controller.selectedColor.value
                                                    )
                                                )
                                            },
                                            enabled = state.seedColor != controller.selectedColor.value,
                                            colors = IconButtonDefaults.filledIconButtonColors()
                                        ) {
                                            Icon(
                                                imageVector = FontAwesomeIcons.Solid.Check,
                                                contentDescription = "Select",
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                    }
                                },
                                colors = ListItemDefaults.colors(
                                    containerColor = cardColors.containerColor,
                                    headlineColor = cardColors.contentColor,
                                    trailingIconColor = cardColors.contentColor
                                )
                            )

                            HsvColorPicker(
                                modifier = Modifier
                                    .height(250.dp)
                                    .padding(10.dp),
                                controller = controller,
                                initialColor = state.seedColor
                            )

                            BrightnessSlider(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .padding(10.dp)
                                    .height(35.dp),
                                controller = controller,
                                initialColor = state.seedColor
                            )
                        }
                    }

                    item {
                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Amoled",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Why would you turn this on?"
                                )
                            },
                            trailingContent = {
                                Switch(
                                    checked = state.isAmoled,
                                    onCheckedChange = {
                                        editState(
                                            state.copy(
                                                isAmoled = !state.isAmoled
                                            )
                                        )
                                    },
                                    enabled = state.isDark
                                )
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = cardColors.containerColor,
                                headlineColor = cardColors.contentColor
                            )
                        )
                    }
                }
            }
        }
    }
}
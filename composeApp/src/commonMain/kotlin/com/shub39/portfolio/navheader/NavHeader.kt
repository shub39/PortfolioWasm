package com.shub39.portfolio.navheader

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.materialkolor.PaletteStyle
import com.materialkolor.ktx.toHct
import com.materialkolor.ktx.toHex
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Check
import compose.icons.fontawesomeicons.solid.Moon
import compose.icons.fontawesomeicons.solid.PaintBrush
import compose.icons.fontawesomeicons.solid.Sun

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavHeader(
    isDark: Boolean,
    seedColor: Color,
    palette: PaletteStyle,
    changeSeedColor: (Color) -> Unit,
    changeTheme: (Boolean) -> Unit,
    changePalette: (PaletteStyle) -> Unit
) {
    var paletteSelectDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                changeTheme(!isDark)
            }
        ) {
            Icon(
                imageVector = if (isDark) {
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
    }

    if (paletteSelectDialog) {
        val controller = rememberColorPickerController()
        val cardColors = CardDefaults.cardColors()

        Dialog(
            onDismissRequest = { paletteSelectDialog = false }
        ) {
            Card(
                modifier = Modifier.padding(vertical = 32.dp),
                shape = MaterialTheme.shapes.large
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
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
                                    checked = isDark,
                                    onCheckedChange = { changeTheme(it) }
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
                                            selected = palette == it,
                                            onClick = { changePalette(it) },
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
                                            onClick = { changeSeedColor(controller.selectedColor.value) },
                                            colors = if (seedColor != controller.selectedColor.value) {
                                                IconButtonDefaults.filledIconButtonColors()
                                            } else {
                                                IconButtonDefaults.iconButtonColors()
                                            }
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
                                initialColor = seedColor
                            )

                            BrightnessSlider(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .padding(10.dp)
                                    .height(35.dp),
                                controller = controller,
                                initialColor = seedColor
                            )
                        }
                    }

                    item {
                        val clipboardManager = LocalClipboardManager.current
                        var colorType by remember { mutableStateOf(ColorType.HEX) }

                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Copy Colors",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Click on the color to copy to clipboard"
                                )
                            },
                            trailingContent = {
                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    ColorType.entries.toList().forEach {
                                        TextButton(
                                            onClick = { colorType = it },
                                            colors = if (colorType == it) {
                                                ButtonDefaults.buttonColors()
                                            } else {
                                                ButtonDefaults.filledTonalButtonColors()
                                            }
                                        ) {
                                            Text(text = it.name)
                                        }
                                    }
                                }
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = cardColors.containerColor,
                                headlineColor = cardColors.contentColor,
                                trailingIconColor = cardColors.contentColor
                            )
                        )

                        ColorSchemeDisplay(
                            onClick = {
                                clipboardManager.setText(
                                    annotatedString = buildAnnotatedString {
                                        append(
                                            when (colorType) {
                                                ColorType.HEX -> it.toHex().toString()
                                                ColorType.RGB -> it.toRgbString()
                                                ColorType.HSL -> it.toHslString()
                                            }
                                        )
                                    }
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
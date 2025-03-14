package com.shub39.portfolio.pages.rush_demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.materialkolor.ktx.lighten
import com.shub39.portfolio.pages.components.ColorPickerDialog
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Copy
import compose.icons.fontawesomeicons.solid.Palette

@Composable
fun ActionsRow(
    state: LyricsPageState,
    editState: (LyricsPageState) -> Unit
) {
    val clipboardManager = LocalClipboardManager.current
    var paletteDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { paletteDialog = true }
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.Palette,
                    contentDescription = "palette",
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(
                onClick = {
                    if (state.selectedLines.isEmpty()) {
                        clipboardManager.setText(
                            buildAnnotatedString {
                                append(state.song.lyrics.joinToString("\n") { it.value })
                            }
                        )
                    } else {
                        clipboardManager.setText(
                            buildAnnotatedString {
                                append(state.selectedLines.values.joinToString("\n"))
                            }
                        )
                    }
                }
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.Copy,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            AnimatedVisibility(visible = state.selectedLines.isNotEmpty()) {
                IconButton(
                    onClick = {
                        editState(
                            state.copy(selectedLines = emptyMap())
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = null
                    )
                }
            }
        }

        if (paletteDialog) {
            Dialog(
                onDismissRequest = { paletteDialog = false }
            ) {
                var colorPickerDialog by remember { mutableStateOf(false) }
                var editTarget by remember { mutableStateOf("content") }

                if (colorPickerDialog) {
                    ColorPickerDialog(
                        initialColor = if (editTarget == "content") Color(state.mCardContent) else Color(
                            state.mCardBackground
                        ),
                        onSelect = {
                            if (editTarget == "content") {
                                editState(
                                    state.copy(
                                        mCardContent = it.toArgb()
                                    )
                                )
                            } else {
                                editState(
                                    state.copy(
                                        mCardBackground = it.toArgb()
                                    )
                                )
                            }
                        },
                        onDismiss = { colorPickerDialog = false }
                    )
                }

                Card(
                    shape = MaterialTheme.shapes.extraLarge,
                    modifier = Modifier.widthIn(max = 500.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ListItem(
                            modifier = Modifier.clip(MaterialTheme.shapes.large),
                            headlineContent = {
                                Text(
                                    text = "Hypnotic Canvas"
                                )
                            },
                            trailingContent = {
                                Switch(
                                    checked = state.hypnoticCanvas,
                                    onCheckedChange = {
                                        editState(
                                            state.copy(
                                                hypnoticCanvas = it
                                            )
                                        )
                                    }
                                )
                            }
                        )

                        ListItem(
                            modifier = Modifier.clip(MaterialTheme.shapes.large),
                            headlineContent = {
                                Text(
                                    text = "Mesh Speed"
                                )
                            },
                            supportingContent = {
                                Slider(
                                    value = state.meshSpeed,
                                    valueRange = 0.5f..3f,
                                    onValueChange = {
                                        editState(
                                            state.copy(
                                                meshSpeed = it
                                            )
                                        )
                                    },
                                    enabled = state.hypnoticCanvas
                                )
                            }
                        )

                        ListItem(
                            modifier = Modifier.clip(MaterialTheme.shapes.large),
                            headlineContent = {
                                Text(
                                    text = "Pick Colors"
                                )
                            },
                            trailingContent = {
                                Row {
                                    IconButton(
                                        onClick = {
                                            editTarget = "content"
                                            colorPickerDialog = true
                                        },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = Color(state.mCardContent),
                                            contentColor = Color(state.mCardContent).lighten(2f)
                                        )
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Create,
                                            contentDescription = "Select Color",
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            editTarget = "background"
                                            colorPickerDialog = true
                                        },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = Color(state.mCardBackground),
                                            contentColor = Color(state.mCardBackground).lighten(2f)
                                        )
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Create,
                                            contentDescription = "Select Color"
                                        )
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
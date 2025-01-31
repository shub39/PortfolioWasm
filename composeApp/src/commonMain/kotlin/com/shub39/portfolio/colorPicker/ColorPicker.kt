package com.shub39.portfolio.colorPicker

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.toHex
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun ColorPicker() {
    val clipboardManager = LocalClipboardManager.current
    var colorType by remember { mutableStateOf(ColorType.HEX) }
    var supportingText by remember { mutableStateOf("Click on the color to copy to clipboard") }

    val cardColors = CardDefaults.cardColors()

    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))

    Card(
        shape = MaterialTheme.shapes.extraLarge,
        modifier = Modifier.border(
            width = 3.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.extraLarge
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ListItem(
                headlineContent = {
                    Text(
                        text = "Copy Colors",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                supportingContent = {
                    AnimatedContent(targetState = supportingText) {
                        Text(
                            text = it,
                            fontFamily = jetbrains
                        )
                    }
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
                                }.also {
                                    supportingText = "copied $it to clipboard"
                                }
                            )
                        }
                    )
                }
            )
        }
    }
}
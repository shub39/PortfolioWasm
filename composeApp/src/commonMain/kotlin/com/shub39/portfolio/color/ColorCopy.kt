package com.shub39.portfolio.color

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.toHex
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun ColorCopy(
    modifier: Modifier = Modifier
) {
    val clipboardManager = LocalClipboardManager.current
    var colorType by remember { mutableStateOf(ColorType.HEX) }
    var supportingText by remember { mutableStateOf("Click on the color to copy to clipboard") }

    val cardColors = CardDefaults.cardColors()

    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))

    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .verticalScroll(scrollState),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 80.dp)
                .widthIn(max = 700.dp),
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(
                containerColor = cardColors.containerColor.copy(alpha = 0.7f)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
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
                    colors = ListItemDefaults.colors(
                        containerColor = Color.Transparent,
                        headlineColor = cardColors.contentColor,
                        supportingColor = cardColors.contentColor
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ColorType.entries.toList().forEach {
                        TextButton(
                            onClick = { colorType = it },
                            colors = if (colorType == it) {
                                ButtonDefaults.buttonColors()
                            } else {
                                ButtonDefaults.filledTonalButtonColors()
                            },
                            modifier = Modifier.padding(horizontal = 4.dp)
                        ) {
                            Text(text = it.name)
                        }
                    }
                }

                ColorSchemeDisplay(
                    onClick = {
                        clipboardManager.setText(
                            annotatedString = buildAnnotatedString {
                                append(
                                    when (colorType) {
                                        ColorType.HEX -> it.toHex()
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
}
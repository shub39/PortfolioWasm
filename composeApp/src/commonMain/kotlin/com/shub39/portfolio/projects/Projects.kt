package com.shub39.portfolio.projects

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun Projects() {
    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))
    val cardColors = CardDefaults.cardColors()

    var projectType by remember { mutableStateOf(ProjectTypes.Apps) }

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
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            ListItem(
                headlineContent = {
                    Text(
                        text = "My Projects",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                supportingContent = {
                    Text(
                        text = "Apps and Other stuff",
                        fontFamily = jetbrains,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                trailingContent = {
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        ProjectTypes.entries.toList().forEach {
                            TextButton(
                                onClick = { projectType = it },
                                colors = if (projectType != it) {
                                    ButtonDefaults.filledTonalButtonColors()
                                } else {
                                    ButtonDefaults.buttonColors()
                                }
                            ) {
                                Text(
                                    text = it.name
                                )
                            }
                        }
                    }
                },
                colors = ListItemDefaults.colors(
                    containerColor = cardColors.containerColor,
                    headlineColor = cardColors.contentColor
                )
            )

            AnimatedContent(projectType) {
                when (it) {
                    ProjectTypes.Apps -> AppPager()
                    ProjectTypes.Others -> OtherPager()
                }
            }
        }
    }
}
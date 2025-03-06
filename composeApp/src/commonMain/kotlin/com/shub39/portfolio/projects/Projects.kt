package com.shub39.portfolio.projects

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.components.ExpandingIconButton
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.solid.Filter
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Projects(
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val cardColors = CardDefaults.cardColors()

    var selectedTech by remember { mutableStateOf(emptySet<MainTech>()) }
    var selectedProjects by remember { mutableStateOf(PROJECTS) }

    LaunchedEffect(selectedTech) {
        selectedProjects = if (selectedTech.isEmpty()) {
            PROJECTS
        } else {
            PROJECTS.filter { project ->
                selectedTech.all { it in project.tech }
            }
        }
    }

    LaunchedEffect(Unit) {
        listState.animateScrollToItem(2)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .animateContentSize()
                .widthIn(max = 700.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.padding(vertical = 80.dp))
            }

            item {
                Card(
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = CardDefaults.cardColors(
                        containerColor = cardColors.containerColor.copy(alpha = 0.7f),
                        contentColor = cardColors.contentColor
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.onPrimary,
                                MaterialTheme.colorScheme.onSecondary,
                                MaterialTheme.colorScheme.onTertiary
                            )
                        )
                    )
                ) {
                    Text(
                        text = "Filters",
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displaySmall
                    )

                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        MainTech.entries.forEach { tech ->
                            FilterChip(
                                shape = CircleShape,
                                modifier = Modifier.padding(horizontal = 8.dp),
                                selected = selectedTech.contains(tech),
                                onClick = {
                                    if (selectedTech.contains(tech)) {
                                        selectedTech = selectedTech.minus(tech)
                                    } else {
                                        selectedTech = selectedTech.plus(tech)

                                        coroutineScope.launch {
                                            listState.animateScrollToItem(2)
                                        }
                                    }
                                },
                                label = { Text(text = tech.tech) }
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            onClick = {
                                selectedTech = emptySet()
                            },
                            enabled = selectedTech.isNotEmpty()
                        ) {
                            Text(
                                text = "Clear"
                            )
                        }
                    }
                }
            }

            item {
                Card(
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = CardDefaults.cardColors(
                        containerColor = cardColors.containerColor.copy(alpha = 0.7f),
                        contentColor = cardColors.contentColor
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            text = if (selectedProjects.isEmpty() && selectedTech.isNotEmpty()) {
                                "Quite the unusual selection of skills you look for..."
                            } else if (selectedTech.isNotEmpty()) {
                                "${selectedProjects.size} Result(s)"
                            } else {
                                "All Projects"
                            }
                        )

                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    listState.animateScrollToItem(0)
                                }
                            }
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.Filter,
                                contentDescription = "Filters",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }

            items(selectedProjects, key = { it.name }) { project ->
                Card(
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = CardDefaults.cardColors(
                        containerColor = cardColors.containerColor.copy(alpha = 0.7f),
                        contentColor = cardColors.contentColor
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            project.iconRes?.let {
                                Image(
                                    painter = painterResource(it),
                                    contentDescription = "App Icon",
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(MaterialTheme.shapes.medium)
                                )
                            }

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = project.name,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = project.shortDesc,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontFamily = FontFamily(Font(Res.font.JetBrainsMono_Regular))
                                )
                            }

                            ExpandingIconButton(
                                onClick = {
                                    uriHandler.openUri(project.github)
                                },
                                tooltip = "Github",
                            ) {
                                Icon(
                                    imageVector = FontAwesomeIcons.Brands.Github,
                                    contentDescription = "Github",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }

                        Text(
                            text = project.desc,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        FlowRow {
                            project.tech.forEach { tech ->
                                AssistChip(
                                    colors = if (tech in selectedTech) {
                                        AssistChipDefaults.elevatedAssistChipColors()
                                    } else {
                                        AssistChipDefaults.assistChipColors()
                                    },
                                    shape = CircleShape,
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    onClick = {
                                        if (selectedTech.contains(tech)) {
                                            selectedTech = selectedTech.minus(tech)
                                        } else {
                                            selectedTech = selectedTech.plus(tech)

                                            coroutineScope.launch {
                                                listState.animateScrollToItem(2)
                                            }
                                        }
                                    },
                                    label = {
                                        Text(
                                            text = tech.tech
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.padding(vertical = 80.dp))
            }
        }
    }
}
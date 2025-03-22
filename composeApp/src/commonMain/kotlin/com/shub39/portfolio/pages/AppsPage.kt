package com.shub39.portfolio.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.Routes
import com.shub39.portfolio.pages.data.APPS
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.GooglePlay
import compose.icons.fontawesomeicons.solid.Globe
import compose.icons.fontawesomeicons.solid.Play
import compose.icons.fontawesomeicons.solid.Star
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AppsPage(
    modifier: Modifier = Modifier,
    navigate: (Routes) -> Unit
) = PageFill {
    val uriHandler = LocalUriHandler.current

    LazyColumn(
        modifier = modifier
            .animateContentSize()
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(APPS, key = { it.name }) { app ->
            var showExpanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier.padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(app.imageResource),
                            contentDescription = app.name,
                            modifier = Modifier
                                .size(75.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        Column {
                            Text(
                                text = app.name,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = app.shortDescription,
                                style = MaterialTheme.typography.titleSmall,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                app.stars?.let {
                                    AssistChip(
                                        onClick = {},
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                                            labelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                        ),
                                        label = { Text(text = it.toString()) },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = FontAwesomeIcons.Solid.Star,
                                                contentDescription = "Star",
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    )
                                }

                                app.rating?.let {
                                    Spacer(modifier = Modifier.width(8.dp))

                                    AssistChip(
                                        onClick = {},
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                            labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onTertiaryContainer
                                        ),
                                        label = { Text(text = it.toString()) },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = FontAwesomeIcons.Brands.GooglePlay,
                                                contentDescription = "Rating",
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    }

                    AnimatedVisibility(
                        visible = showExpanded
                    ) {
                        Column {
                            Text(
                                text = app.description
                            )

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.padding(vertical = 16.dp)
                            ) {
                                app.demo?.let {
                                    ElevatedAssistChip(
                                        onClick = { navigate(it) },
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                            labelColor = MaterialTheme.colorScheme.onSecondary,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onSecondary
                                        ),
                                        label = { Text(text = "Demo") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = FontAwesomeIcons.Solid.Play,
                                                contentDescription = "Demo",
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    )
                                }

                                app.github?.let {
                                    ElevatedAssistChip(
                                        onClick = { uriHandler.openUri(it) },
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.tertiary,
                                            labelColor = MaterialTheme.colorScheme.onTertiary,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onTertiary
                                        ),
                                        label = { Text(text = "Github") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = FontAwesomeIcons.Brands.Github,
                                                contentDescription = "Github",
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    )
                                }

                                app.playstore?.let {
                                    ElevatedAssistChip(
                                        onClick = { uriHandler.openUri(it) },
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.primary,
                                            labelColor = MaterialTheme.colorScheme.onPrimary,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onPrimary
                                        ),
                                        label = { Text(text = "Play Store") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = FontAwesomeIcons.Brands.GooglePlay,
                                                contentDescription = "Playstore",
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    )
                                }

                                app.otherLinks?.let { links ->
                                    links.forEach {
                                        ElevatedAssistChip(
                                            onClick = { uriHandler.openUri(it.value) },
                                            shape = CircleShape,
                                            colors = AssistChipDefaults.assistChipColors(
                                                containerColor = MaterialTheme.colorScheme.primary,
                                                labelColor = MaterialTheme.colorScheme.onPrimary,
                                                leadingIconContentColor = MaterialTheme.colorScheme.onPrimary
                                            ),
                                            label = { Text(text = it.key) },
                                            leadingIcon = {
                                                Icon(
                                                    imageVector = FontAwesomeIcons.Solid.Globe,
                                                    contentDescription = it.key,
                                                    modifier = Modifier.size(18.dp)
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Icon(
                        imageVector = if (!showExpanded) {
                            Icons.Default.ArrowDropDown
                        } else {
                            Icons.Default.Close
                        },
                        modifier = Modifier.clickable { showExpanded = !showExpanded },
                        contentDescription = "Drop Down"
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
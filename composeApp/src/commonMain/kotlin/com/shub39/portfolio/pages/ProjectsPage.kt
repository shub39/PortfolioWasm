package com.shub39.portfolio.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.shub39.portfolio.pages.data.PROJECTS
import com.shub39.portfolio.util.PageFill
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.Shimmer
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Globe
import compose.icons.fontawesomeicons.solid.Star
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProjectsPage(
    modifier: Modifier = Modifier
) = PageFill {
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()

    var dialogImage by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }

        items(PROJECTS, key = { it.name }) { project ->
            Card(
                modifier = Modifier.padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = project.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = project.shortDescription,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )

                    project.screenshots?.let { screenshots ->
                        Box {
                            val state = rememberLazyListState()

                            LazyRow(
                                state = state,
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(screenshots) {
                                    CoilImage(
                                        imageModel = { it },
                                        component = rememberImageComponent {
                                            +ShimmerPlugin(
                                                Shimmer.Resonate(
                                                    baseColor = Color.Transparent,
                                                    highlightColor = MaterialTheme.colorScheme.onSurface
                                                )
                                            )
                                        },
                                        modifier = Modifier
                                            .width(project.imageDimensions.first.dp)
                                            .height(project.imageDimensions.second.dp)
                                            .clip(MaterialTheme.shapes.small)
                                            .clickable { dialogImage = it }
                                    )
                                }
                            }

                            FilledTonalIconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        state.animateScrollToItem(
                                            (state.firstVisibleItemIndex + 1).coerceAtLeast(0)
                                        )
                                    }
                                },
                                modifier = Modifier.align(Alignment.CenterEnd)
                            ) {
                                Icon(
                                    imageVector = FontAwesomeIcons.Solid.ArrowRight,
                                    contentDescription = "Scroll Right",
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            FilledTonalIconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        state.animateScrollToItem(
                                            (state.firstVisibleItemIndex - 1).coerceAtLeast(0)
                                        )
                                    }
                                },
                                modifier = Modifier.align(Alignment.CenterStart)
                            ) {
                                Icon(
                                    imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                                    contentDescription = "Scroll Left",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }

                    FlowRow(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        project.github?.let {
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

                        project.stars?.let {
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

                        project.links?.let {
                            it.forEach { link ->
                                AssistChip(
                                    onClick = { uriHandler.openUri(link.second) },
                                    shape = CircleShape,
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                        labelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                        leadingIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                    ),
                                    label = { Text(text = link.first) },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = FontAwesomeIcons.Solid.Globe,
                                            contentDescription = "Star",
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                )
                            }
                        }
                    }

                    Text(
                        text = project.description,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    if (dialogImage != null) {
        Dialog(
            onDismissRequest = { dialogImage = null },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Box(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CoilImage(
                    imageModel = { dialogImage },
                    modifier = Modifier.fillMaxHeight(),
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Fit
                    )
                )

                FilledTonalIconButton(
                    onClick = { dialogImage = null },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
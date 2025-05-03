package com.shub39.portfolio.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.shub39.portfolio.pages.data.APPS
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
import compose.icons.fontawesomeicons.brands.GooglePlay
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Globe
import compose.icons.fontawesomeicons.solid.Star
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AppsPage(
    modifier: Modifier = Modifier,
) = PageFill {
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()

    var dialogImage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "My Apps",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        APPS.forEach { app ->
            Card(
                modifier = Modifier.padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.5f),
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
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
                        CoilImage(
                            imageModel = { app.iconUrl },
                            component = rememberImageComponent {
                                +ShimmerPlugin(
                                    Shimmer.Resonate(
                                        baseColor = Color.Transparent,
                                        highlightColor = MaterialTheme.colorScheme.onSurface
                                    )
                                )
                            },
                            failure = {
                                Icon(
                                    imageVector = FontAwesomeIcons.Solid.Globe,
                                    contentDescription = "Icon",
                                    modifier = Modifier.size(75.dp)
                                )
                            },
                            modifier = Modifier
                                .size(85.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        Column {
                            Text(
                                text = app.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = app.shortDescription,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                fontWeight = FontWeight.Bold,
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

                    Box {
                        val state = rememberLazyListState()

                        LazyRow(
                            state = state,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(app.screenshots) {
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
                                        .width(180.dp)
                                        .height(320.dp)
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

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = app.description,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(vertical = 16.dp)
                        ) {
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
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
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
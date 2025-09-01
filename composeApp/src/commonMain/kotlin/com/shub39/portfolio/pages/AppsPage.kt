package com.shub39.portfolio.pages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFlexibleTopAppBar
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialShapes.Companion.Sunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.shub39.portfolio.data.APPS
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.GooglePlay
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)
@Composable
fun AppsPage(
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var screenshots by remember { mutableStateOf<List<String>>(emptyList()) }

    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            LargeFlexibleTopAppBar(
                title = { Text(text = "My Apps") },
                subtitle = { Text(text = "Apps I wished to exist") },
                scrollBehavior = scrollBehaviour,
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding(),
                bottom = padding.calculateBottomPadding() + 16.dp,
                start = padding.calculateStartPadding(LocalLayoutDirection.current) + 16.dp,
                end = padding.calculateEndPadding(LocalLayoutDirection.current) + 16.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(APPS) { app ->
                var showDetails by rememberSaveable { mutableStateOf(false) }

                val containerColor by animateColorAsState(
                    targetValue = if (!showDetails) {
                        MaterialTheme.colorScheme.secondaryContainer
                    } else {
                        MaterialTheme.colorScheme.primaryContainer
                    }
                )

                val contentColor by animateColorAsState(
                    targetValue = if (!showDetails) {
                        MaterialTheme.colorScheme.onSecondaryContainer
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    }
                )

                val cornerRadius by animateDpAsState(
                    targetValue = if (!showDetails) 100.dp else 32.dp
                )

                Card(
                    modifier = Modifier.animateContentSize(),
                    onClick = { showDetails = !showDetails },
                    shape = RoundedCornerShape(cornerRadius),
                    colors = CardDefaults.cardColors(
                        containerColor = containerColor,
                        contentColor = contentColor
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CoilImage(
                            imageModel = { app.iconUrl },
                            modifier = Modifier
                                .size(80.dp)
                                .clip(Sunny.toShape())
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = app.name,
                                style = MaterialTheme.typography.titleLarge
                            )

                            Text(
                                text = app.shortDescription,
                                style = MaterialTheme.typography.bodyLarge,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.alpha(0.8f)
                            )
                        }
                    }

                    if (showDetails) {
                        val buttonSize = ButtonDefaults.MediumContainerHeight
                        FlowRow(
                            modifier = Modifier.padding(12.dp),
                            horizontalArrangement = ButtonGroupDefaults.HorizontalArrangement
                        ) {
                            Button(
                                onClick = { screenshots = app.screenshots },
                                modifier = Modifier.height(buttonSize)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Smartphone,
                                    contentDescription = null,
                                    modifier = Modifier.size(ButtonDefaults.MediumIconSize)
                                )
                                Spacer(modifier = Modifier.width(ButtonDefaults.MediumIconSpacing))
                                Text(
                                    text = "Screenshots",
                                    style = ButtonDefaults.textStyleFor(buttonSize)
                                )
                            }

                            app.github?.let {
                                IconButton(
                                    onClick = { uriHandler.openUri(it) },
                                    modifier = Modifier.height(buttonSize)
                                ) {
                                    Icon(
                                        imageVector = FontAwesomeIcons.Brands.Github,
                                        contentDescription = null,
                                        modifier = Modifier.size(ButtonDefaults.MediumIconSize)
                                    )
                                }
                            }

                            app.playstore?.let {
                                IconButton(
                                    onClick = { uriHandler.openUri(it) },
                                    modifier = Modifier.height(buttonSize)
                                ) {
                                    Icon(
                                        imageVector = FontAwesomeIcons.Brands.GooglePlay,
                                        contentDescription = null,
                                        modifier = Modifier.size(ButtonDefaults.MediumIconSize)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    if (screenshots.isNotEmpty()) {
        val coroutineScope = rememberCoroutineScope()
        val pagerState = rememberPagerState { screenshots.size }

        Dialog(
            onDismissRequest = { screenshots = emptyList() },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(32.dp),
                    modifier = Modifier.fillMaxSize(),
                    key = { screenshots[it] }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CoilImage(
                            imageModel = { screenshots[it] },
                            imageOptions = ImageOptions(
                                contentScale = ContentScale.Fit
                            ),
                            modifier = Modifier
                                .height(this@BoxWithConstraints.maxHeight - 150.dp)
                                .clip(MaterialTheme.shapes.small),
                            loading = {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    LoadingIndicator(
                                        modifier = Modifier.size(100.dp)
                                    )
                                }
                            }
                        )
                    }
                }

                FilledTonalIconButton(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterEnd),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                maxOf(0, pagerState.currentPage + 1)
                            )
                        }
                    },
                    shape = RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp),
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Next",
                        modifier = Modifier.size(40.dp)
                    )
                }

                FilledTonalIconButton(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterStart),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                maxOf(pagerState.currentPage - 1, 0)
                            )
                        }
                    },
                    shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Next",
                        modifier = Modifier.size(40.dp)
                    )
                }

                FilledTonalIconButton(
                    onClick = { screenshots = emptyList() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(20.dp)
                        .size(50.dp)

                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

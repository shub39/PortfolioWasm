package com.shub39.portfolio.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialShapes.Companion.Square
import androidx.compose.material3.MaterialShapes.Companion.Sunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.shub39.portfolio.data.APPS
import com.shub39.portfolio.util.PageFill
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.GooglePlay
import compose.icons.fontawesomeicons.solid.Globe
import compose.icons.fontawesomeicons.solid.Mobile
import compose.icons.fontawesomeicons.solid.Star
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)
@Composable
fun AppsPage(
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    var screenshots by remember { mutableStateOf<List<String>>(emptyList()) }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    shape = MaterialTheme.shapes.extraExtraLarge,
                    modifier = Modifier.padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Brands.Android,
                            contentDescription = "Android",
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = "My Apps",
                            style = MaterialTheme.typography.displayMediumEmphasized
                        )
                    }
                }
            }
        }

        itemsIndexed(APPS) { index, app ->
            Card(
                modifier = Modifier.padding(horizontal = 16.dp),
                shape = when (index) {
                    0 -> RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )

                    APPS.lastIndex -> RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )

                    else -> RoundedCornerShape(10.dp)
                },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
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
                            failure = {
                                Icon(
                                    imageVector = FontAwesomeIcons.Solid.Globe,
                                    contentDescription = "Icon",
                                    modifier = Modifier.size(75.dp)
                                )
                            },
                            loading = {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    LoadingIndicator()
                                }
                            },
                            modifier = Modifier
                                .size(100.dp)
                                .clip(Square.toShape())
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        Column {
                            Text(
                                text = app.name,
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = FontWeight.Bold
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                app.stars?.let {
                                    AssistChip(
                                        onClick = {},
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.primary,
                                            labelColor = MaterialTheme.colorScheme.onPrimary,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onPrimary
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

                                Spacer(modifier = Modifier.width(4.dp))

                                app.rating?.let {
                                    AssistChip(
                                        onClick = {},
                                        shape = CircleShape,
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.tertiary,
                                            labelColor = MaterialTheme.colorScheme.onTertiary,
                                            leadingIconContentColor = MaterialTheme.colorScheme.onTertiary
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

                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = { screenshots = app.screenshots },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            modifier = Modifier.size(50.dp),
                            shapes = IconButtonShapes(
                                shape = Sunny.toShape(),
                                pressedShape = Square.toShape()
                            )
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.Mobile,
                                contentDescription = "Screenshots",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = app.shortDescription,
                            style = MaterialTheme.typography.titleLargeEmphasized,
                            fontWeight = FontWeight.Bold
                        )

                        FlowRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Spacer(modifier = Modifier.weight(1f))

                            app.github?.let {
                                Button(
                                    onClick = { uriHandler.openUri(it) },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.primary,
                                        contentColor = MaterialTheme.colorScheme.onPrimary
                                    ),
                                    shapes = ButtonShapes(
                                        shape = RoundedCornerShape(20.dp),
                                        pressedShape = RoundedCornerShape(10.dp)
                                    )
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Icon(
                                            imageVector = FontAwesomeIcons.Brands.Github,
                                            contentDescription = "Github",
                                            modifier = Modifier.size(24.dp)
                                        )

                                        Text("Github")
                                    }
                                }
                            }

                            app.playstore?.let {
                                Button(
                                    onClick = { uriHandler.openUri(it) },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondary,
                                        contentColor = MaterialTheme.colorScheme.onSecondary
                                    ),
                                    shapes = ButtonShapes(
                                        shape = RoundedCornerShape(10.dp),
                                        pressedShape = RoundedCornerShape(20.dp)
                                    )
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Icon(
                                            imageVector = FontAwesomeIcons.Brands.GooglePlay,
                                            contentDescription = "Playstore",
                                            modifier = Modifier.size(24.dp)
                                        )

                                        Text("Playstore")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
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
                    PageFill {
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
                    shapes = IconButtonShapes(
                        shape = CircleShape,
                        pressedShape = Square.toShape()
                    ),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(32.dp)
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
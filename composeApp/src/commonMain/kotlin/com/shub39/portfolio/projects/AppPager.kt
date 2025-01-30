package com.shub39.portfolio.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.GooglePlay
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Globe
import compose.icons.fontawesomeicons.solid.Store
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun AppPager() {
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { MY_APPS.size }

    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))
    val cardColors = CardDefaults.cardColors()

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            userScrollEnabled = false
        ) {
            val app = MY_APPS[it]

            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                colors = cardColors
            ) {
                ListItem(
                    headlineContent = {
                        Text(
                            text = app.name
                        )
                    },
                    supportingContent = {
                        Column {
                            Text(
                                text = app.shortDesc,
                                fontFamily = jetbrains
                            )

                            Row {
                                IconButton(
                                    onClick = { uriHandler.openUri(app.github) }
                                ) {
                                    Icon(
                                        imageVector = FontAwesomeIcons.Brands.Github,
                                        contentDescription = "Github",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                                app.links.forEach {
                                    IconButton(
                                        onClick = { uriHandler.openUri(it.value) }
                                    ) {
                                        Icon(
                                            imageVector = when (it.key) {
                                                AppSources.PlayStore.name -> FontAwesomeIcons.Brands.GooglePlay
                                                AppSources.FDroid.name -> FontAwesomeIcons.Solid.Store
                                                else -> FontAwesomeIcons.Solid.Globe
                                            },
                                            contentDescription = "Link",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            }
                        }
                    },
                    leadingContent = {
                        Image(
                            painter = painterResource(app.iconRes),
                            contentDescription = "App Icon",
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.large)
                                .size(100.dp)
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = cardColors.containerColor,
                        leadingIconColor = cardColors.contentColor,
                        headlineColor = cardColors.contentColor,
                        supportingColor = cardColors.contentColor
                    )
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                enabled = pagerState.currentPage > 0
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                    contentDescription = "Left Arrow",
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage  + 1)
                    }
                },
                enabled = pagerState.currentPage < MY_APPS.size - 1
            ) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.ArrowRight,
                    contentDescription = "Right Arrow",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
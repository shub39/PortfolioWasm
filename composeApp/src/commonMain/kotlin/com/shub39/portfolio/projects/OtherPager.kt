package com.shub39.portfolio.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res

@Composable
fun OtherPager() {
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { MY_PROJECTS.size }

    val jetbrains = FontFamily(Font(Res.font.JetBrainsMono_Regular))
    val cardColors = CardDefaults.cardColors()

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            userScrollEnabled = false
        ) {
            val project = MY_PROJECTS[it]

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                colors = cardColors
            ) {
                ListItem(
                    headlineContent = {
                        Text(
                            text = project.name
                        )
                    },
                    supportingContent = {
                        Text(
                            text = project.shortDesc,
                            fontFamily = jetbrains
                        )
                    },
                    trailingContent = {
                        IconButton(
                            onClick = { uriHandler.openUri(project.github) }
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Brands.Github,
                                contentDescription = "Github",
                                modifier = Modifier.size(24.dp)
                            )
                        }
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
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                enabled = pagerState.currentPage < MY_PROJECTS.size - 1
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
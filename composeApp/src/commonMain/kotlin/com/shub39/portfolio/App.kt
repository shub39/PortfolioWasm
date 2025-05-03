package com.shub39.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mikepenz.hypnoticcanvas.shaderBackground
import com.mikepenz.hypnoticcanvas.shaders.MeshGradient
import com.shub39.portfolio.ColorState.Companion.randomColor
import com.shub39.portfolio.pages.AboutPage
import com.shub39.portfolio.pages.AppsPage
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.pages.ProjectsPage
import com.shub39.portfolio.pages.components.ThemerOptions
import com.shub39.portfolio.pages.data.NavigateInfo
import com.shub39.portfolio.util.PortfolioTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Tools
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun App() {
    val listState = rememberLazyListState()
    var showDrawer by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val currentIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }
    var colorState by remember { mutableStateOf(ColorState()) }
    var drawerState = rememberDrawerState(DrawerValue.Closed)

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            colorState = colorState.randomColor()
        }
    }

    PortfolioTheme(
        state = colorState
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            LaunchedEffect(this.maxWidth) {
                showDrawer = this@BoxWithConstraints.maxWidth > 1100.dp
                drawerState.close()
            }

            Surface(
                color = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxSize()
                    .let {
                        if (showDrawer) {
                            it.shaderBackground(
                                MeshGradient(
                                    colors = arrayOf(
                                        MaterialTheme.colorScheme.surface,
                                        MaterialTheme.colorScheme.primaryContainer,
                                        MaterialTheme.colorScheme.tertiaryContainer,
                                        MaterialTheme.colorScheme.secondaryContainer,
                                        MaterialTheme.colorScheme.surface
                                    ),
                                    scale = 2f
                                ),
                                speed = 2f
                            )
                        } else it.background(
                            brush = Brush.linearGradient(
                                listOf(
                                    MaterialTheme.colorScheme.surface,
                                    MaterialTheme.colorScheme.primaryContainer,
                                    MaterialTheme.colorScheme.tertiaryContainer,
                                    MaterialTheme.colorScheme.secondaryContainer,
                                    MaterialTheme.colorScheme.surface
                                )
                            )
                        )
                    }
            ) {
                Row {
                   AnimatedVisibility(
                       visible = showDrawer
                   ) {
                       DismissibleDrawerSheet(
                           drawerState = DrawerState(DrawerValue.Open),
                           drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
                           drawerContainerColor = MaterialTheme.colorScheme.surface,
                           drawerContentColor = MaterialTheme.colorScheme.onSurface
                       ) {
                           Spacer(modifier = Modifier.padding(16.dp))

                           listOf(
                               NavigateInfo(FontAwesomeIcons.Solid.Home, 0, "Home"),
                               NavigateInfo(FontAwesomeIcons.Brands.Android, 1, "Apps"),
                               NavigateInfo(FontAwesomeIcons.Solid.Tools, 2, "Projects"),
                               NavigateInfo(FontAwesomeIcons.Solid.Male, 3, "About")
                           ).forEach {
                               NavigationDrawerItem(
                                   modifier = Modifier.padding(horizontal = 4.dp),
                                   label = { Text(it.title) },
                                   selected = currentIndex == it.index,
                                   onClick = {
                                       scope.launch { listState.animateScrollToItem(it.index) }
                                   },
                                   icon = {
                                       Icon(
                                           imageVector = it.imageVector,
                                           contentDescription = it.title,
                                           modifier = Modifier.size(20.dp)
                                       )
                                   }
                               )
                           }

                           HorizontalDivider(
                               modifier = Modifier.padding(vertical = 8.dp, horizontal = 32.dp),
                               color = MaterialTheme.colorScheme.onSurfaceVariant
                           )

                           ThemerOptions(
                               colorState = colorState,
                               stateEdit = { colorState = it }
                           )
                       }
                   }

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            state = listState
                        ) {
                            item {
                                HomePage(
                                    modifier = Modifier
                                        .height(this@BoxWithConstraints.maxHeight)
                                        .fillMaxWidth()
                                )
                            }

                            item {
                                AppsPage(
                                    modifier = Modifier
                                        .heightIn(min = this@BoxWithConstraints.maxHeight)
                                        .widthIn(max = 800.dp)
                                )
                            }

                            item {
                                ProjectsPage(
                                    modifier = Modifier
                                        .heightIn(min = this@BoxWithConstraints.maxHeight)
                                        .widthIn(max = 800.dp)
                                )
                            }

                            item {
                                AboutPage(
                                    modifier = Modifier
                                        .heightIn(min = this@BoxWithConstraints.maxHeight)
                                        .widthIn(max = 800.dp)
                                )
                            }
                        }

                        if (!showDrawer) {
                            FilledTonalIconButton(
                                onClick = { scope.launch { drawerState.open() } },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .align(Alignment.TopStart)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    }
                }
            }

            DismissibleNavigationDrawer(
                drawerContent = {
                    DismissibleDrawerSheet(
                        drawerState = drawerState,
                        drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
                        drawerContainerColor = MaterialTheme.colorScheme.surface,
                        drawerContentColor = MaterialTheme.colorScheme.onSurface
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(
                                onClick = { scope.launch { drawerState.close() } }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close"
                                )
                            }
                        }

                        listOf(
                            NavigateInfo(FontAwesomeIcons.Solid.Home, 0, "Home"),
                            NavigateInfo(FontAwesomeIcons.Brands.Android, 1, "Apps"),
                            NavigateInfo(FontAwesomeIcons.Solid.Tools, 2, "Projects"),
                            NavigateInfo(FontAwesomeIcons.Solid.Male, 3, "About")
                        ).forEach {
                            NavigationDrawerItem(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                label = { Text(it.title) },
                                selected = currentIndex == it.index,
                                onClick = {
                                    scope.launch {
                                        drawerState.close()
                                        listState.animateScrollToItem(it.index)
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = it.imageVector,
                                        contentDescription = it.title,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            )
                        }

                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 32.dp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        ThemerOptions(
                            colorState = colorState,
                            stateEdit = { colorState = it }
                        )
                    }
                },
                drawerState = drawerState,
                gesturesEnabled = false,
                content = {
                    if (drawerState.isOpen) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { scope.launch { drawerState.close() } }
                        )
                    }
                }
            )
        }
    }
}


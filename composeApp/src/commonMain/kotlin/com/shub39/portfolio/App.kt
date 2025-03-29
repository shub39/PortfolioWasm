package com.shub39.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikepenz.hypnoticcanvas.shaderBackground
import com.mikepenz.hypnoticcanvas.shaders.MeshGradient
import com.shub39.portfolio.pages.AboutPage
import com.shub39.portfolio.pages.AppsPage
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.pages.ProjectsPage
import com.shub39.portfolio.pages.components.ThemerOptions
import com.shub39.portfolio.pages.data.NavigateInfo
import com.shub39.portfolio.pages.rush_demo.RushDemo
import com.shub39.portfolio.util.PortfolioTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Tools
import kotlinx.coroutines.launch

@Composable
internal fun App(
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()

    var colorState by remember { mutableStateOf(ColorState()) }
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    var currentRoute: Routes by remember { mutableStateOf(Routes.HomePage) }

    PortfolioTheme(
        state = colorState
    ) {
        Surface(
            color = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .fillMaxSize()
                .shaderBackground(
                    MeshGradient(
                        colors = arrayOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.tertiaryContainer,
                            MaterialTheme.colorScheme.secondaryContainer,
                            MaterialTheme.colorScheme.surface
                        )
                    ),
                    speed = 3f
                )
        ) {
            Box {
                AnimatedVisibility(
                    visible = currentRoute != Routes.RushDemo,
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Row(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(16.dp)
                    ) {
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                }

                NavHost(
                    modifier = Modifier.background(Color.Transparent),
                    navController = navController,
                    startDestination = Routes.HomePage
                ) {
                    composable<Routes.HomePage> {
                        currentRoute = Routes.HomePage
                        HomePage()
                    }
                    composable<Routes.AppsPage> {
                        currentRoute = Routes.AppsPage
                        AppsPage(
                            modifier = Modifier
                                .padding(top = 72.dp)
                                .widthIn(max = 700.dp),
                            navigate = {
                                navController.navigate(it) {
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                    composable<Routes.RushDemo> {
                        currentRoute = Routes.RushDemo

                        RushDemo(
                            onBack = { navController.navigateUp() }
                        )
                    }
                    composable<Routes.AboutPage> {
                        currentRoute = Routes.AboutPage
                        AboutPage(
                            modifier = Modifier
                                .padding(top = 72.dp)
                                .widthIn(max = 700.dp)
                        )
                    }
                    composable<Routes.ProjectsPage> {
                        currentRoute = Routes.ProjectsPage
                        ProjectsPage(
                            modifier = Modifier
                                .padding(top = 72.dp)
                                .widthIn(max = 700.dp)
                        )
                    }
                }
            }
        }

        DismissibleNavigationDrawer(
            drawerContent = {
                DismissibleDrawerSheet(
                    drawerState = drawerState,
                    drawerContainerColor = MaterialTheme.colorScheme.surface,
                    drawerContentColor = MaterialTheme.colorScheme.onSurface,
                    drawerShape = RoundedCornerShape(
                        topEnd = 20.dp,
                        bottomEnd = 20.dp
                    )
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
                        NavigateInfo(FontAwesomeIcons.Solid.Home, Routes.HomePage, "Home"),
                        NavigateInfo(FontAwesomeIcons.Brands.Android, Routes.AppsPage, "Apps"),
                        NavigateInfo(FontAwesomeIcons.Solid.Tools, Routes.ProjectsPage, "Projects"),
                        NavigateInfo(FontAwesomeIcons.Solid.Male, Routes.AboutPage, "About")
                    ).forEach {
                        NavigationDrawerItem(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            label = { Text(it.title) },
                            selected = currentRoute == it.route,
                            onClick = {
                                if (currentRoute != it.route) {
                                    navController.navigate(it.route)
                                    scope.launch { drawerState.close() }
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
                        modifier = Modifier.padding(8.dp),
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
            content = {}
        )
    }
}


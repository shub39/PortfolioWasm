package com.shub39.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shub39.portfolio.pages.AboutPage
import com.shub39.portfolio.pages.AppsPage
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.pages.ProjectsPage
import com.shub39.portfolio.pages.ThemerPage
import com.shub39.portfolio.pages.rush_demo.RushDemo
import com.shub39.portfolio.util.PortfolioTheme

@Composable
internal fun App(
    navController: NavHostController
) {
    var colorState by remember { mutableStateOf(ColorState()) }

    PortfolioTheme(
        state = colorState
    ) {
        NavHost(
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            navController = navController,
            startDestination = Routes.HomePage
        ) {
            composable<Routes.HomePage> {
                HomePage(
                    modifier = Modifier.widthIn(max = 700.dp),
                    navigate = {
                        navController.navigate(it) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Routes.AppsPage> {
                AppsPage(
                    modifier = Modifier.widthIn(max = 700.dp),
                    navigate = {
                        navController.navigate(it) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Routes.RushDemo> {
                RushDemo(
                    onBack = { navController.navigateUp() }
                )
            }
            composable<Routes.AboutPage> {
                AboutPage(
                    modifier = Modifier.widthIn(max = 700.dp),
                    navigate = {
                        navController.navigate(it) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Routes.ProjectsPage> {
                ProjectsPage(
                    modifier = Modifier.widthIn(max = 700.dp),
                    navigate = {
                        navController.navigate(it) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Routes.ThemerPage> {
                ThemerPage(
                    modifier = Modifier.widthIn(max = 700.dp),
                    colorState = colorState,
                    stateEdit = { colorState = it },
                    navigate = {
                        navController.navigate(it) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}


package com.shub39.portfolio

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shub39.portfolio.pages.AppsPage
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.util.PortfolioTheme

@Composable
internal fun App() {
    var colorState by remember { mutableStateOf(ColorState()) }
    val navController = rememberNavController()

    PortfolioTheme(
        state = colorState
    ) {
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Routes.HomePage
        ) {
            composable<Routes.HomePage> {
                HomePage(
                    modifier = Modifier.widthIn(max = 500.dp),
                    navigate = { navController.navigate(it) }
                )
            }
            composable<Routes.AppsPage> {
                AppsPage(
                    modifier = Modifier.widthIn(max = 500.dp),
                    navigate = { navController.navigate(it) }
                )
            }
            composable<Routes.AboutPage> { }
            composable<Routes.ProjectsPage> { }
            composable<Routes.ThemerPage> { }
        }
    }
}


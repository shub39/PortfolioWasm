package com.shub39.portfolio

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.shub39.portfolio.Routes.Companion.routes
import com.shub39.portfolio.data.NavigationDestination
import com.shub39.portfolio.pages.AppsPage
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.util.PortfolioTheme
import kotlinx.serialization.Serializable

@Serializable
private sealed interface Routes {
    @Serializable
    data object Home : Routes
    @Serializable
    data object Apps : Routes

    companion object {
        val routes = listOf(
            NavigationDestination(
                icon = Icons.Rounded.Home,
                label = "Home",
                route = Routes.Home
            ),
            NavigationDestination(
                icon = Icons.Rounded.Apps,
                label = "Apps",
                route = Routes.Apps
            )
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun App() {
    var colorState by remember { mutableStateOf(ColorState()) }
    var currentPage: Routes by remember { mutableStateOf(Routes.Home) }

    PortfolioTheme(
        state = colorState
    ) {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                routes.forEach { route ->
                    item(
                        selected = currentPage == route.route,
                        onClick = { currentPage = route.route },
                        icon = {
                            Icon(
                                imageVector = route.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(route.label) }
                    )
                }
            }
        ) {
            AnimatedContent(
                targetState = currentPage,
                modifier = Modifier.fillMaxSize()
            ) {
                when (it) {
                    Routes.Home -> {
                        HomePage(
                            modifier = Modifier.fillMaxHeight(),
                            onNavigateToApps = {
                                currentPage = Routes.Apps
                            }
                        )
                    }

                    Routes.Apps -> {
                        AppsPage(
                            modifier = Modifier.fillMaxHeight()
                        )
                    }
                }
            }
        }
    }
}
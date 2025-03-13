package com.shub39.portfolio

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shub39.portfolio.pages.HomePage
import com.shub39.portfolio.util.PageFill
import com.shub39.portfolio.util.PortfolioTheme

@Composable
internal fun App() {
    var colorState by remember { mutableStateOf(ColorState()) }
    val navController = rememberNavController()

    PortfolioTheme(
        state = colorState
    ) {
        PageFill {
            Scaffold(
                modifier = Modifier.widthIn(max = 700.dp),
                bottomBar = {
                    BottomAppBar(
                        modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    ) {

                    }
                }
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = Routes.HomePage,
                    modifier = Modifier.padding(padding)
                ) {
                    composable<Routes.HomePage> {
                        PageFill {
                            HomePage(
                                modifier = Modifier
                                    .widthIn(max = 500.dp)
                                    .padding(32.dp)
                            )
                        }
                    }
                    composable<Routes.AppsPage> { }
                    composable<Routes.AboutPage> { }
                    composable<Routes.ProjectsPage> { }
                    composable<Routes.ThemerPage> { }
                }
            }
        }
    }
}


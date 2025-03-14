package com.shub39.portfolio.pages

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import com.shub39.portfolio.Routes
import com.shub39.portfolio.pages.components.BottomBar
import com.shub39.portfolio.pages.data.NavigateInfo
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectsPage(
    modifier: Modifier = Modifier,
    navigate: (Routes) -> Unit
) = PageFill {
    val uriHandler = LocalUriHandler.current

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Other Projects") }
            )
        },
        bottomBar = {
            BottomBar(
                navigate = navigate,
                list = listOf(
                    NavigateInfo(FontAwesomeIcons.Solid.Home, Routes.HomePage, "Home"),
                    NavigateInfo(FontAwesomeIcons.Brands.Android, Routes.AppsPage, "Projects"),
                    NavigateInfo(FontAwesomeIcons.Solid.Male, Routes.AboutPage, "About"),
                    NavigateInfo(FontAwesomeIcons.Solid.Palette, Routes.ThemerPage, "Colors")
                )
            )
        }
    ) { padding ->

    }
}
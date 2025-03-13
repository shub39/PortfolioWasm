package com.shub39.portfolio.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.Routes
import com.shub39.portfolio.pages.components.ExpandingIconButton
import com.shub39.portfolio.pages.data.NavigateInfo
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Palette
import compose.icons.fontawesomeicons.solid.Tools

@Composable
fun AppsPage(
    modifier: Modifier = Modifier,
    navigate: (Routes) -> Unit
) = PageFill {

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    listOf(
                        NavigateInfo(FontAwesomeIcons.Solid.Home, Routes.HomePage, "Apps"),
                        NavigateInfo(FontAwesomeIcons.Solid.Tools, Routes.ProjectsPage, "Projects"),
                        NavigateInfo(FontAwesomeIcons.Solid.Male, Routes.AboutPage, "About"),
                        NavigateInfo(FontAwesomeIcons.Solid.Palette, Routes.ThemerPage, "Colors")
                    ).forEach { info ->
                        ExpandingIconButton(
                            onClick = { navigate(info.route) },
                            tooltip = info.title
                        ) {
                            Icon(
                                imageVector = info.imageVector,
                                contentDescription = info.title,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { padding ->

    }

}
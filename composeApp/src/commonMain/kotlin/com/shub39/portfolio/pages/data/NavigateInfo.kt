package com.shub39.portfolio.pages.data

import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Tools

data class NavigateInfo(
    val imageVector: ImageVector,
    val index: Int,
    val title: String
)

val SECTIONS = listOf(
    NavigateInfo(FontAwesomeIcons.Solid.Home, 0, "Home"),
    NavigateInfo(FontAwesomeIcons.Brands.Android, 1, "Apps"),
    NavigateInfo(FontAwesomeIcons.Solid.Tools, 2, "Projects"),
    NavigateInfo(FontAwesomeIcons.Solid.Male, 3, "About")
)


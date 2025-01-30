package com.shub39.portfolio.projects

import org.jetbrains.compose.resources.DrawableResource

data class App(
    val name: String,
    val shortDesc: String,
    val desc: String,
    val github: String,
    val links: Map<String, String>,
    val iconRes: DrawableResource
)

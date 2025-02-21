package com.shub39.portfolio.projects

import org.jetbrains.compose.resources.DrawableResource

data class Project(
    val name: String,
    val shortDesc: String,
    val desc: String,
    val github: String,
    val iconRes: DrawableResource?,
    val tech: List<MainTech>
)
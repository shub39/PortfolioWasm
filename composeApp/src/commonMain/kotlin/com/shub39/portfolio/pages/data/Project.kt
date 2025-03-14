package com.shub39.portfolio.pages.data

data class Project(
    val name: String,
    val shortDescription: String,
    val description: String,
    val github: String? = null,
    val stars: Int? = null
)

val PROJECTS = listOf(
    Project(
        name = "Portfolio",
        shortDescription = "This site",
        description = "This site was made using Kotlin/Wasm and deployed on netlify",
        github = "https://github.com/shub39/PortofolioWasm"
    ),
    Project(
        name = "Dotfiles",
        shortDescription = "Dotfiles for my Arch + Hyprland setup",
        description = "Dotfiles stand for configuration files, as an Arch Linux user " +
                "these are my heavily customised dotfiles for the Hyprland tiling window " +
                "manager.",
        stars = 200,
        github = "https://github.com/shub39/dotfiles"
    ),
    Project(
        name = "Student-Dropper",
        shortDescription = "Attendance system using raspberry pi 4",
        description = "This is a simple biometric attendance system made using " +
                "Raspberry Pi using python as the scripting language " +
                "It supports fingerprint and face recognition and currently " +
                "under development",
        github = "https://github.com/shub39/biometric-attendance"
    )
)
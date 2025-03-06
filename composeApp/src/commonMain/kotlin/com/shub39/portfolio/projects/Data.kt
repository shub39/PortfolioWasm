package com.shub39.portfolio.projects

import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.dharmik_icon
import portfolio.composeapp.generated.resources.grit_icon
import portfolio.composeapp.generated.resources.plumbus_icon
import portfolio.composeapp.generated.resources.rush_icon

val PROJECTS = listOf(
    
    // Apps
    Project(
        name = "Rush",
        shortDesc = "Lyrics App",
        desc = "Rush is an Android App to get lyrics for your favorite tracks and share them through " +
                "colorful cards, with features like synced lyrics and importing lyrics for local files. " +
                "it is a perfect tool for audiophiles and music nerds like myself. It is available on " +
                "Playstore and has 450+ stars on Github",
        github = "https://github.com/shub39/Rush",
        iconRes = Res.drawable.rush_icon,
        tech = listOf(
            MainTech.Android, MainTech.AndroidStudio, MainTech.MVI,
            MainTech.Material3, MainTech.Koin, MainTech.JetpackCompose,
            MainTech.CleanArch, MainTech.Ktor, MainTech.Fdroid,
            MainTech.Playstore, MainTech.IzzyOnDroid, MainTech.Room,
            MainTech.Kotlin, MainTech.DataStore
        )
    ),
    Project(
        name = "Grit",
        shortDesc = "Todo list and Habit Tracker",
        desc = "Grit is a simple TODO list and Habit tracker for android that helps you " +
                "visualise your progress through maps. It has daily reminders for habits, categories " +
                "for tasks and a simple Home Screen Widget. Has 120+ Stars on Github",
        github = "https://www.github.com/shub39/Grit",
        iconRes = Res.drawable.grit_icon,
        tech = listOf(
            MainTech.Android, MainTech.AndroidStudio, MainTech.MVI,
            MainTech.Material3, MainTech.Koin, MainTech.JetpackCompose,
            MainTech.CleanArch, MainTech.Fdroid, MainTech.IzzyOnDroid,
            MainTech.Room, MainTech.Kotlin, MainTech.Widgets, MainTech.DataStore
        )
    ),
    Project(
        name = "Plumbus",
        shortDesc = "Browse info on Rick and Morty",
        desc = "Plumbus is a Compose Multiplatform app targeting android and desktop that " +
                "lets you browse information on characters, episodes and locations from the Rick and Morty" +
                " Universe. Participated in the KotlinConf Contest 2025",
        github = "https://github.com/shub39/Plumbus",
        iconRes = Res.drawable.plumbus_icon,
        tech = listOf(
            MainTech.Android, MainTech.AndroidStudio, MainTech.MVI,
            MainTech.Material3, MainTech.Koin, MainTech.ComposeMultiplatform,
            MainTech.CleanArch, MainTech.Room, MainTech.Kotlin, MainTech.Desktop,
            MainTech.Ktor
        )
    ),
    Project(
        name = "Dharmik",
        shortDesc = "Browse Hindu Texts",
        desc = "Dharmik is a Compose Multiplatform app targeting android and desktop. " +
                "It is a completely offline browser for Hindu Texts complete with bookmarks, " +
                "copy to clipboard, and liked feature for verses. It currently contains Bhagavad Gita " +
                "and Atharvaveda",
        github = "https://github.com/shub39/Dharmik",
        iconRes = Res.drawable.dharmik_icon,
        tech = listOf(
            MainTech.Android, MainTech.AndroidStudio, MainTech.MVI, MainTech.IzzyOnDroid,
            MainTech.Material3, MainTech.Koin, MainTech.ComposeMultiplatform,
            MainTech.CleanArch, MainTech.Room, MainTech.Kotlin, MainTech.Desktop
        )
    ),
    
    // Others
    Project(
        name = "Portfolio",
        shortDesc = "This site",
        desc = "This site was made using Kotlin/Wasm and deployed on netlify. " +
                "It's mainly to showcase my work and has a basic Material theme color " +
                "palette generator that I find myself using often",
        github = "https://github.com/shub39/PortfolioWasm",
        iconRes = null,
        tech = listOf(
            MainTech.Kotlin, MainTech.ComposeMultiplatform, MainTech.WebAssembly,
            MainTech.Material3, MainTech.AndroidStudio
        )
    ),
    Project(
        name = "Dotfiles",
        shortDesc = "I use Arch btw",
        desc = "Dotfiles stand for configuration files, as an Arch Linux user " +
                "these are my heavily customised dotfiles for the Hyprland tiling window " +
                "manager, It has 200+ stars on Github",
        github = "https://github.com/shub39/dotfiles",
        iconRes = null,
        tech = listOf(
            MainTech.Shell, MainTech.Linux
        )
    ),
    Project(
        name = "Student Dropper",
        shortDesc = "Iot attendance system",
        desc = "This is a simple biometric attendance system made using " +
                "Raspberry Pi using python as the scripting language " +
                "It supports fingerprint and face recognition and currently " +
                "under development",
        github = "https://github.com/shub39/student-dropper",
        iconRes = null,
        tech = listOf(
            MainTech.Iot, MainTech.Rpi, MainTech.Python
        )
    )
)
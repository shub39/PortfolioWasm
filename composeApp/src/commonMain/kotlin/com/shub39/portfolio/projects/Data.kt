package com.shub39.portfolio.projects

import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.grit_icon
import portfolio.composeapp.generated.resources.plumbus_icon
import portfolio.composeapp.generated.resources.rush_icon

val MY_APPS = listOf<App>(
    App(
        name = "Rush",
        shortDesc = "Search, Save and Share lyrics like Spotify!",
        desc = "Rush is an Android App to get lyrics for your favorite tracks and share them through " +
                "colorful cards, with features like synced lyrics and importing lyrics for local files. " +
                "it is a perfect tool for audiophiles and music nerds like myself.",
        github = "https://github.com/shub39/Rush",
        links = mapOf(
            AppSources.PlayStore.name to "https://play.google.com/store/apps/details?id=com.shub39.rush.play",
            AppSources.FDroid.name to "https://f-droid.org/packages/com.shub39.rush/",
            AppSources.Izzy.name to "https://apt.izzysoft.de/packages/com.shub39.rush/latest"
        ),
        iconRes = Res.drawable.rush_icon
    ),
    App(
        name = "Grit",
        shortDesc = "A simple TODO list and Habit Tracker",
        desc = "Grit is a simple TODO list and Habit tracker for android that helps you " +
                "visualise your progress through maps.",
        github = "https://www.github.com/shub39/Grit",
        links = mapOf(
            AppSources.FDroid.name to "https://f-droid.org/packages/com.shub39.grit/",
            AppSources.Izzy.name to "https://apt.izzysoft.de/packages/com.shub39.grit/latest"
        ),
        iconRes = Res.drawable.grit_icon
    ),
    App(
        name = "Plumbus",
        shortDesc = "Multiplatform app to browse info on the Rick and Morty universe",
        desc = "Plumbus is a Compose Multiplatform app targeting android and desktop that " +
                "lets you browse information on characters, episodes and locations from the Rick and Morty" +
                " Universe",
        github = "https://github.com/shub39/Plumbus",
        links = mapOf(),
        iconRes = Res.drawable.plumbus_icon
    )
)

val MY_PROJECTS = listOf<OtherProject>(
    OtherProject(
        name = "Portfolio Site",
        shortDesc = "My portfolio site made using kobweb",
        desc = "This site was made in compose multiplatform using kobweb, " +
                "a web framework for kotlin and compose. This is for primarily " +
                "showcasing my work and some basic utilities like color pickers " +
                "that I find myself using often.",
        github = "https://github.com/shub39/portfolio"
    ),

    OtherProject(
        name = "Biometric Attendance",
        shortDesc = "An attendance system made with raspberry pi 4B",
        desc = "This is a simple biometric attendance system made with " +
                "Raspberry Pi 4B, it can enroll students through fingerprints, take attendance and share them" +
                "directly with teachers to save time during classes, A better version with facial recognition is " +
                "currently in the works.",
        github = "https://github.com/shub39/biometric-attendance"
    ),

    OtherProject(
        name = "Dotfiles",
        shortDesc = "dotfiles for my Arch linux + Hyprland config",
        desc = "dotfiles stand for configuration files. As an arch user I've spent a lot of time customising " +
                "my desktop for maximum productivity and performance without looking bad. Used some basic shell scripting " +
                "and CSS to get this",
        github = "https://github.com/shub39/dotfiles"
    )
)
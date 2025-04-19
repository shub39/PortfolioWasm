package com.shub39.portfolio.pages.data

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.dharmik_icon
import portfolio.composeapp.generated.resources.grit_icon
import portfolio.composeapp.generated.resources.plumbus_icon
import portfolio.composeapp.generated.resources.rush_icon

data class App(
    val name: String,
    val imageResource: DrawableResource,
    val shortDescription: String,
    val description: String,
    val github: String? = null,
    val stars: Int? = null,
    val rating: Float? = null,
    val playstore: String? = null,
    val otherLinks: Map<String, String>? = null,
)

val APPS = listOf(
    App(
        name = "Rush",
        shortDescription = "Search, Save and Share Lyrics like Spotify!",
        imageResource = Res.drawable.rush_icon,
        description = "Rush is an Android App to get lyrics for your favorite tracks and share them through " +
                "colorful cards, with features like synced lyrics and importing lyrics for local files. " +
                "it is a perfect tool for audiophiles and music nerds like myself.",
        github = "https://github.com/shub39/Rush",
        stars = 540,
        rating = 5f,
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.rush.play",
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.rush",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.rush/latest"
        )
    ),
    App(
        name = "Grit",
        shortDescription = "A simple ToDo list and Habit Tracker",
        imageResource = Res.drawable.grit_icon,
        description = "There are plenty of todo list and habit tracker apps for android. " +
                "Some have the features I love while some have good UI design." +
                " While learning android I made this app for myself that brings together all the features that I" +
                " like keeping everything simple.",
        github = "https://github.com/shub39/Grit",
        stars = 150,
        playstore = null,
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.grit",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.grit/latest"
        )
    ),
    App(
        name = "Dharmik",
        shortDescription = "Browse Bhagavad Gita",
        imageResource = Res.drawable.dharmik_icon,
        description = "A simple app to browse Bhagavad Gita with auduio transcriptions in three languages",
        github = "https://github.com/shub39/Dharmik",
        stars = 31,
        playstore = null,
        otherLinks = mapOf(
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.dharmik/latest"
        )
    ),
    App(
        name = "Plumbus",
        shortDescription = "Browse info on Rick and Morty",
        imageResource = Res.drawable.plumbus_icon,
        description = "Compose Multiplatform app to browse info on Characters, " +
                "Locations and Episodes from Rick and Morty.",
        github = "https://github.com/shub39/Plumbus",
        stars = 13,
        playstore = null,
        otherLinks = null
    )
)
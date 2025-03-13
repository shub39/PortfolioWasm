package com.shub39.portfolio.pages.data

import com.shub39.portfolio.Routes

data class App(
    val name: String,
    val shortDescription: String,
    val description: String,
    val github: String? = null,
    val demo: Routes? = null,
    val playstore: String? = null,
    val otherLinks: Map<String, String>? = null
)

val APPS = listOf(
    App(
        name = "Rush",
        shortDescription = "Search, Save and Share Lyrics like Spotify!",
        description = "Rush is an Android App to get lyrics for your favorite tracks and share them through " +
                "colorful cards, with features like synced lyrics and importing lyrics for local files. " +
                "it is a perfect tool for audiophiles and music nerds like myself. It is available on " +
                "Playstore and has 450+ stars on Github",
        github = "https://github.com/shub39/Rush",
        demo = null,
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.rush.play",
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.rush",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.rush/latest"
        )
    ),
    App(
        name = "Grit",
        shortDescription = "A simple ToDo list and Habit Tracker",
        description = "There are plenty of todo list and habit tracker apps for android. " +
                "Some have the features I love while some have good UI design." +
                " While learning android I made this app for myself that brings together all the features that I" +
                " like keeping everything simple.",
        github = "https://github.com/shub39/Grit",
        demo = null,
        playstore = null,
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.grit",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.grit/latest"
        )
    ),
    App(
        name = "Dharmik",
        shortDescription = "Browse Hindu Texts",
        description = "A simple app to browse Hindu texts, currently contains Atharvaveda and Bhagavad Gita",
        github = "https://github.com/shub39/Dharmik",
        demo = null,
        playstore = null,
        otherLinks = mapOf(
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.dharmik/latest"
        )
    ),
    App(
        name = "Plumbus",
        shortDescription = "Browse info on Rick and Morty",
        description = "Compose Multiplatform app to browse info on Characters, " +
                "Locations and Epicsodes from Rick and Morty.",
        github = "https://github.com/shub39/Plumbus",
        demo = null,
        playstore = null,
        otherLinks = null
    )
)
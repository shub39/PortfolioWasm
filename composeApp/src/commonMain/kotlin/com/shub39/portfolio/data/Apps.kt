package com.shub39.portfolio.data

data class App(
    val name: String,
    val iconUrl: String,
    val screenshots: List<String>,
    val shortDescription: String,
    val github: String? = null,
    val playstore: String? = null,
    val skills: List<Skills> = emptyList()
)

val APPS = listOf(
    App(
        name = "Rush",
        iconUrl = "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/icon.png",
        screenshots = listOf(
            "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/1.png",
            "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/2.png",
            "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/3.png",
            "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/4.png",
            "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/5.png",
            "https://raw.githubusercontent.com/shub39/Rush/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/6.png",
        ),
        shortDescription = "Search, Save and Share Lyrics like Spotify!",
        github = "https://github.com/shub39/Rush",
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.rush.play",
        skills = listOf(
            Skills.JETPACK_COMPOSE, Skills.KOTLIN, Skills.KTOR_CLIENT, Skills.MVI, Skills.KOIN,
            Skills.ROOM
        )
    ),
    App(
        name = "Grit",
        iconUrl = "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/icon.png",
        screenshots = listOf(
            "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/1.png",
            "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/2.png",
            "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/3.png",
            "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/4.png",
            "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/5.png",
            "https://raw.githubusercontent.com/shub39/Grit/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/6.png",
        ),
        shortDescription = "A simple ToDo list and Habit Tracker",
        github = "https://github.com/shub39/Grit",
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.grit",
        skills = listOf(
            Skills.JETPACK_COMPOSE, Skills.KOTLIN, Skills.MVI, Skills.KOIN,
            Skills.ROOM
        )
    ),
    App(
        name = "Momentum",
        iconUrl = "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/icon.png",
        screenshots = listOf(
            "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/1.png",
            "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/2.png",
            "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/3.png",
            "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/4.png",
            "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/5.png",
            "https://raw.githubusercontent.com/shub39/Momentum/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/6.png",
        ),
        shortDescription = "App to make Montages easily",
        github = "https://github.com/shub39/Momentum",
        playstore = "https://play.google.com/store/apps/details?id=shub39.momentum",
        skills = listOf(
            Skills.JETPACK_COMPOSE, Skills.KOTLIN, Skills.MVI, Skills.KOIN,
            Skills.ROOM, Skills.ML_KIT
        )
    ),
    App(
        name = "Dharmik",
        iconUrl = "https://raw.githubusercontent.com/shub39/Dharmik/refs/heads/master/fastlane/metadata/android/en-US/images/icon.png",
        screenshots = listOf(
            "https://raw.githubusercontent.com/shub39/Dharmik/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/1.png",
            "https://raw.githubusercontent.com/shub39/Dharmik/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/2.png",
            "https://raw.githubusercontent.com/shub39/Dharmik/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/3.png",
            "https://raw.githubusercontent.com/shub39/Dharmik/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/4.png",
        ),
        shortDescription = "Browse Bhagavad Gita",
        github = "https://github.com/shub39/Dharmik",
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.dharmik.online",
        skills = listOf(
            Skills.JETPACK_COMPOSE, Skills.KOTLIN, Skills.KTOR_CLIENT, Skills.MVI, Skills.KOIN,
            Skills.ROOM, Skills.CMP
        )
    ),
    App(
        name = "Plumbus",
        iconUrl = "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/icon.png",
        screenshots = listOf(
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/1.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/2.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/3.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/4.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/5.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/6.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/7.png",
            "https://raw.githubusercontent.com/shub39/Plumbus/refs/heads/master/fastlane/metadata/android/en-US/images/phoneScreenshots/8.png"
        ),
        shortDescription = "Browse info on Rick and Morty",
        github = "https://github.com/shub39/Plumbus",
        skills = listOf(
            Skills.JETPACK_COMPOSE, Skills.KOTLIN, Skills.KTOR_CLIENT, Skills.MVI, Skills.KOIN,
            Skills.ROOM, Skills.CMP
        )
    )
)
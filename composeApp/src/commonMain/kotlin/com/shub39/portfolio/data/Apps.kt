package com.shub39.portfolio.data

data class App(
    val name: String,
    val iconUrl: String,
    val screenshots: List<String>,
    val shortDescription: String,
    val github: String? = null,
    val stars: Int? = null,
    val rating: Float? = null,
    val playstore: String? = null,
    val otherLinks: Map<String, String>? = null,
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
        stars = 650,
        rating = 5f,
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.rush.play",
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.rush",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.rush/latest"
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
        stars = 350,
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.grit",
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.grit",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.grit/latest"
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
        stars = 0,
        playstore = "https://play.google.com/store/apps/details?id=shub39.momentum",
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.grit",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.grit/latest"
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
        stars = 50,
        playstore = "https://play.google.com/store/apps/details?id=com.shub39.dharmik.online",
        otherLinks = mapOf(
            "Fdroid" to "https://f-droid.org/packages/com.shub39.dharmik",
            "IzzyOnDroid" to "https://apt.izzysoft.de/packages/com.shub39.dharmik/latest"
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
        stars = 20,
        playstore = null,
        otherLinks = null
    )
)
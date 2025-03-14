package com.shub39.portfolio

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object HomePage: Routes

    @Serializable
    data object AppsPage: Routes

    @Serializable
    data object RushDemo: Routes

    @Serializable
    data object ProjectsPage: Routes

    @Serializable
    data object AboutPage: Routes

    @Serializable
    data object ThemerPage: Routes
}
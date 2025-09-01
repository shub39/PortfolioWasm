package com.shub39.portfolio.data

enum class Skills {
    KOTLIN,
    JETPACK_COMPOSE,
    CMP,
    KTOR_CLIENT,
    ML_KIT,
    ROOM,
    MVI,
    KOIN;

    companion object {
        fun Skills.toText(): String {
            return when (this) {
                KOTLIN -> "Kotlin"
                JETPACK_COMPOSE -> "Jetpack Compose"
                CMP -> "Compose Multiplatform"
                KTOR_CLIENT -> "Ktor-Client"
                ML_KIT -> "MlKit"
                ROOM -> "Room"
                MVI -> "MVI"
                KOIN -> "Koin"
            }
        }
    }
}
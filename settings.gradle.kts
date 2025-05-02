rootProject.name = "Portfolio"

pluginManagement {
    repositories {
        google {
            content { 
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            content { 
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        mavenCentral()
    }
}
include(":composeApp")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}
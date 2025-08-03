@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.reload.gradle.ComposeHotRun
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.hotreload)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.preloader)
}

preloader {
    jsModuleName.set("composeApp")
    logo.set(project.file("src/commonMain/composeResources/drawable/eclipse.svg"))
}

kotlin {
    jvm("desktop")

    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.composeIcons.fontAwesome)
            implementation(libs.materialKolor)
            implementation(libs.landscapist.coil)
            implementation(libs.landscapist.placeholder)
            implementation(libs.material.icons.core)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }

    }
}

compose.desktop {
    application {
        mainClass = "com.shub39.portfolio.MainKt"
    }
}

composeCompiler {
    featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
}

tasks.register<Delete>("deleteSiteDir") {
    dependsOn("wasmJsBrowserDistribution")

    delete(layout.projectDirectory.dir("site"))
}

tasks.register<Copy>("copyWasmArtifacts") {
    dependsOn("deleteSiteDir")

    from(layout.buildDirectory.dir("dist/wasmJs/productionExecutable"))
    into(layout.projectDirectory.dir("site"))
}

tasks.withType<ComposeHotRun>().configureEach {
    mainClass.set("com.shub39.portfolio.MainKt")
}
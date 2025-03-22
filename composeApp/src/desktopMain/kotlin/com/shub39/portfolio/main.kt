package com.shub39.portfolio

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.reload.DevelopmentEntryPoint


fun main() {
    singleWindowApplication(
        title = "Hot Reload",
        state = WindowState(width = 800.dp, height = 800.dp),
        alwaysOnTop = true
    ) {
        val navController = rememberNavController()

        DevelopmentEntryPoint {
            App(navController)
        }
    }
}
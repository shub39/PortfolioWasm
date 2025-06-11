package com.shub39.portfolio.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialShapes.Companion.Sunny
import androidx.compose.material3.MaterialShapes.Companion.VerySunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BackgroundShapes(
    modifier: Modifier = Modifier,
    visible: Boolean = true
) {
    val infiniteTransition = rememberInfiniteTransition(label = "corner_shapes_rotation")

    val rotationDegrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation_animation"
    )

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(1000)),
        exit = fadeOut(tween(1000))
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .aspectRatio(1f)
                    .rotate(rotationDegrees)
                    .border(
                        width = 3.dp,
                        color = MaterialTheme.colorScheme.secondary,
                        shape = VerySunny.toShape()
                    )
                    .align(Alignment.Center)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .aspectRatio(1f)
                    .rotate(rotationDegrees)
                    .border(
                        width = 3.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = Sunny.toShape()
                    )
                    .align(Alignment.Center)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .rotate(rotationDegrees)
                    .border(
                        width = 3.dp,
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = VerySunny.toShape()
                    )
                    .align(Alignment.CenterEnd)
            )
        }
    }
}
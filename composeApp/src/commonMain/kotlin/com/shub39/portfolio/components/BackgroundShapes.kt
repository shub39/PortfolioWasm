package com.shub39.portfolio.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialShapes.Companion.Arch
import androidx.compose.material3.MaterialShapes.Companion.Burst
import androidx.compose.material3.MaterialShapes.Companion.Clover4Leaf
import androidx.compose.material3.MaterialShapes.Companion.Diamond
import androidx.compose.material3.MaterialShapes.Companion.Gem
import androidx.compose.material3.MaterialShapes.Companion.Pentagon
import androidx.compose.material3.MaterialShapes.Companion.Pill
import androidx.compose.material3.MaterialShapes.Companion.Square
import androidx.compose.material3.MaterialShapes.Companion.Sunny
import androidx.compose.material3.MaterialShapes.Companion.VerySunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon
import com.shub39.portfolio.util.PageFill

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
private val allShapes = listOf(
    Sunny,
    Square,
    VerySunny,
    Pill,
    Arch,
    Pentagon,
    Gem,
    Diamond,
    Burst,
    Clover4Leaf
)

private data class BackgroundShape(
    val shape: RoundedPolygon,
    val color: Color
)

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BackgroundShapes(
    visible: Boolean
) = PageFill {
    val colors = listOf(
        MaterialTheme.colorScheme.inversePrimary,
        MaterialTheme.colorScheme.inverseSurface,
        MaterialTheme.colorScheme.surfaceVariant,
        MaterialTheme.colorScheme.inverseOnSurface
    )
    val shapes by remember {
        mutableStateOf(
            (0..20).map {
                BackgroundShape(
                    shape = allShapes.random(),
                    color = colors.random()
                )
            }
        )
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 4
        ) {
            shapes.forEach {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .aspectRatio(1f)
                        .background(
                            color = it.color,
                            shape = it.shape.toShape()
                        )
                )
            }
        }
    }
}
package com.shub39.portfolio.color

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.materialkolor.PaletteStyle
import com.materialkolor.ktx.from
import com.materialkolor.palettes.TonalPalette
import com.materialkolor.rememberDynamicColorScheme
import com.shub39.portfolio.ColorState
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Check

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ColorPicker(
    state: ColorState,
    editState: (ColorState) -> Unit,
    modifier: Modifier = Modifier
) {
    val cardColors = CardDefaults.cardColors()

    val controller = rememberColorPickerController()

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .animateContentSize()
                .widthIn(max = 700.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.padding(vertical = 60.dp))
            }

            item {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = cardColors.containerColor.copy(alpha = 0.7f)
                    ),
                    modifier = Modifier
                        .widthIn(max = 700.dp),
                    shape = MaterialTheme.shapes.extraLarge
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Select Palette Style",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Select the variant of palette generated from seed color"
                                )
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = Color.Transparent,
                                headlineColor = cardColors.contentColor,
                                supportingColor = cardColors.contentColor
                            )
                        )

                        FlowRow {
                            PaletteStyle.entries.toList().forEach { style ->
                                val scheme = rememberDynamicColorScheme(
                                    primary = state.seedColor,
                                    isDark = state.isDark,
                                    isAmoled = state.isAmoled,
                                    style = style
                                )

                                SelectableMiniPalette(
                                    selected = state.style == style,
                                    onClick = {
                                        editState(
                                            state.copy(
                                                style = style
                                            )
                                        )
                                    },
                                    contentDescription = { style.name },
                                    accents = listOf(
                                        TonalPalette.from(scheme.primary),
                                        TonalPalette.from(scheme.tertiary),
                                        TonalPalette.from(scheme.secondary)
                                    )
                                )
                            }
                        }

                        ListItem(
                            headlineContent = {
                                Text(
                                    text = "Select Seed Color",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },
                            supportingContent = {
                                Text(
                                    text = "Click on the Check Icon to generate palette"
                                )
                            },
                            trailingContent = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AlphaTile(
                                        modifier = Modifier
                                            .size(50.dp)
                                            .padding(10.dp)
                                            .clip(CircleShape),
                                        controller = controller
                                    )

                                    IconButton(
                                        onClick = {
                                            editState(
                                                state.copy(
                                                    seedColor = controller.selectedColor.value
                                                )
                                            )
                                        },
                                        enabled = state.seedColor != controller.selectedColor.value,
                                        colors = IconButtonDefaults.filledIconButtonColors()
                                    ) {
                                        Icon(
                                            imageVector = FontAwesomeIcons.Solid.Check,
                                            contentDescription = "Select",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = Color.Transparent,
                                headlineColor = cardColors.contentColor,
                                supportingColor = cardColors.contentColor,
                                trailingIconColor = cardColors.contentColor
                            )
                        )

                        HsvColorPicker(
                            modifier = Modifier
                                .height(250.dp)
                                .padding(10.dp),
                            controller = controller,
                            initialColor = state.seedColor
                        )

                        BrightnessSlider(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .padding(10.dp)
                                .height(35.dp),
                            controller = controller,
                            initialColor = state.seedColor
                        )
                    }
                }
            }

            item {
                ColorCopy()
            }

            item {
                Spacer(modifier = Modifier.padding(vertical = 80.dp))
            }
        }
    }
}

// yeeted from https://github.com/SkyD666/PodAura/blob/master/app/src/main/java/com/skyd/anivu/ui/screen/settings/appearance/AppearanceScreen.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectableMiniPalette(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    contentDescription: () -> String,
    accents: List<TonalPalette>,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = Color.Transparent,
    ) {
        TooltipBox(
            modifier = modifier,
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip {
                    Text(contentDescription())
                }
            },
            state = rememberTooltipState()
        ) {
            Surface(
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .padding(12.dp)
                    .size(50.dp),
                shape = CircleShape,
                color = Color(accents[0].tone(60))
            ) {
                Box {
                    Surface(
                        modifier = Modifier
                            .size(50.dp)
                            .offset((-25).dp, 25.dp),
                        color = Color(accents[1].tone(85)),
                    ) {}
                    Surface(
                        modifier = Modifier
                            .size(50.dp)
                            .offset(25.dp, 25.dp),
                        color = Color(accents[2].tone(75)),
                    ) {}
                    val animationSpec = spring<Float>(stiffness = Spring.StiffnessMedium)
                    AnimatedVisibility(
                        visible = selected,
                        enter = scaleIn(animationSpec) + fadeIn(animationSpec),
                        exit = scaleOut(animationSpec) + fadeOut(animationSpec),
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Check,
                                contentDescription = "Checked",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(16.dp),
                                tint = MaterialTheme.colorScheme.surface
                            )
                        }
                    }
                }
            }
        }
    }
}
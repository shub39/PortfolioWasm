package com.shub39.portfolio.pages.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.ColorState
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Random

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ThemerOptions(
    modifier: Modifier = Modifier,
    colorState: ColorState,
    stateEdit: (ColorState) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            ListItem(
                headlineContent = {
                    Text("Dark Mode")
                },
                supportingContent = {
                    Text("Toggle the site's Theme")
                },
                trailingContent = {
                    Switch(
                        checked = colorState.isDark,
                        onCheckedChange = {
                            stateEdit(
                                colorState.copy(
                                    isDark = !colorState.isDark
                                )
                            )
                        }
                    )
                }
            )
        }

        item {
            ListItem(
                headlineContent = {
                    Text("Pure Black")
                },
                supportingContent = {
                    Text("AMOLED mode")
                },
                trailingContent = {
                    Switch(
                        checked = colorState.isAmoled,
                        enabled = colorState.isDark,
                        onCheckedChange = {
                            stateEdit(
                                colorState.copy(
                                    isAmoled = !colorState.isAmoled
                                )
                            )
                        }
                    )
                }
            )
        }

        item {
            ListItem(
                headlineContent = {
                    Text("Palette Mix")
                },
                supportingContent = {
                    Text("Randomize colors and style")
                },
                trailingContent = {
                    FilledTonalIconButton(
                        onClick = {
                            stateEdit(
                                colorState.copy(
                                    seedColor = ColorState.randomColor(),
                                    style = ColorState.randomStyle()
                                )
                            )
                        }
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.Random,
                            contentDescription = "Random",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            )
        }
    }
}
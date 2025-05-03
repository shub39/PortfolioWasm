package com.shub39.portfolio.pages.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shub39.portfolio.ColorState

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
    }
}
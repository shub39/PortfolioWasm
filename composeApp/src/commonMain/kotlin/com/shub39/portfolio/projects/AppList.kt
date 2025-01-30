package com.shub39.portfolio.projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res

@Composable
fun AppList() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MY_APPS.forEach { app ->
            ListItem(
                modifier = Modifier.clip(MaterialTheme.shapes.large),
                leadingContent = {
                    Icon(
                        painter = painterResource(app.iconRes),
                        contentDescription = "AppIcon",
                        modifier = Modifier.size(48.dp)
                    )
                },
                headlineContent = {
                    Text(
                        text = app.name
                    )
                },
                supportingContent = {
                    Text(
                        text = app.shortDesc
                    )
                },
                trailingContent = {
                    Row {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Brands.Github,
                                contentDescription = "Github"
                            )
                        }
                    }
                }
            )
        }
    }
}
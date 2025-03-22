package com.shub39.portfolio.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.pages.data.ButtonInfo
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.brands.Telegram
import compose.icons.fontawesomeicons.solid.Envelope
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.jetbrainsmono

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomePage() = PageFill {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "{shub39}",
            fontFamily = FontFamily(Font(Res.font.jetbrainsmono)),
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Beginner Android dev and Linux nerd from India",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            horizontalArrangement = Arrangement.Center
        ) {
            listOf(
                ButtonInfo(
                    FontAwesomeIcons.Brands.Github,
                    "https://github.com/shub39",
                    "Github"
                ),
                ButtonInfo(
                    FontAwesomeIcons.Brands.Linkedin,
                    "https://www.linkedin.com/in/shub39/",
                    "LinkedIn"
                ),
                ButtonInfo(FontAwesomeIcons.Brands.Telegram, "https://t.me/shub39", "Telegram"),
                ButtonInfo(
                    FontAwesomeIcons.Solid.Envelope,
                    "mailto:cptnshubham39@gmail.com",
                    "Email"
                )
            ).forEach { buttonInfo ->
                AssistChip(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = { uriHandler.openUri(buttonInfo.link) },
                    label = { Text(buttonInfo.title) },
                    shape = CircleShape,
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        labelColor = MaterialTheme.colorScheme.onTertiary,
                        leadingIconContentColor = MaterialTheme.colorScheme.onTertiary
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = buttonInfo.imageVector,
                            contentDescription = buttonInfo.title,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )
            }
        }
    }

}
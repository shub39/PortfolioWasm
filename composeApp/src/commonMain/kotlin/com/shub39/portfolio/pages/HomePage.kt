package com.shub39.portfolio.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.pages.components.ExpandingIconButton
import com.shub39.portfolio.pages.data.ButtonInfo
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.brands.Telegram
import compose.icons.fontawesomeicons.solid.Envelope
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.JetBrainsMono_Regular
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.eclipse

@Composable
fun HomePage(
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.eclipse),
                    contentDescription = "Eclipse",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                )

                Text(
                    text = "{shub39}",
                    fontFamily = FontFamily(Font(Res.font.JetBrainsMono_Regular)),
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Beginner Android dev and Linux nerd",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            listOf(
                ButtonInfo(FontAwesomeIcons.Brands.Github, "https://github.com/shub39", "Github"),
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
                ExpandingIconButton(
                    onClick = { uriHandler.openUri(buttonInfo.link) },
                    tooltip = buttonInfo.title
                ) {
                    Icon(
                        imageVector = buttonInfo.imageVector,
                        contentDescription = buttonInfo.title,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

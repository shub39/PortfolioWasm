package com.shub39.portfolio.intro

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.brands.Telegram
import compose.icons.fontawesomeicons.solid.Envelope

@Composable
fun SocialLinksRow() {
    val uriHandler = LocalUriHandler.current

    Row {
        IconButton(
            onClick = { uriHandler.openUri("https://github.com/shub39") }
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Brands.Github,
                contentDescription = "Github",
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = { uriHandler.openUri("https://t.me/shub39") }
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Brands.Telegram,
                contentDescription = "Telegram",
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = { uriHandler.openUri("https://www.linkedin.com/in/shub39/") }
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Brands.Linkedin,
                contentDescription = "LinkedIn",
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = { uriHandler.openUri("mailto:cptnshubham39@gmail.com") }
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Solid.Envelope,
                contentDescription = "Email",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
package com.shub39.portfolio.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
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
import compose.icons.fontawesomeicons.brands.Twitter
import compose.icons.fontawesomeicons.solid.ArrowUp
import compose.icons.fontawesomeicons.solid.Envelope
import compose.icons.fontawesomeicons.solid.Mouse

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) = PageFill(modifier = modifier) {
    val uriHandler = LocalUriHandler.current

    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = Modifier
            .padding(bottom = 32.dp)
            .align(Alignment.BottomCenter)
    ) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Mouse,
            contentDescription = "Scroll",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Icon(
            imageVector = FontAwesomeIcons.Solid.ArrowUp,
            contentDescription = "Scroll",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text("Scroll")
    }

    Box(
        modifier = Modifier
            .padding(32.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier.padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Shubham Gorai",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = "Android dev and Linux nerd from India",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
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
                    ButtonInfo(
                        FontAwesomeIcons.Solid.Envelope,
                        "mailto:cptnshubham39@gmail.com",
                        "Email"
                    ),
                    ButtonInfo(
                        FontAwesomeIcons.Brands.Twitter,
                        "https://x.com/_shub39",
                        "twitter"
                    )
                ).forEach { buttonInfo ->
                    IconButton(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            contentColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        onClick = { uriHandler.openUri(buttonInfo.link) }
                    ) {
                        Icon(
                            imageVector = buttonInfo.imageVector,
                            contentDescription = buttonInfo.title,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}
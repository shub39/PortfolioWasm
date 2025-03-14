package com.shub39.portfolio.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.Routes
import com.shub39.portfolio.pages.data.ButtonInfo
import com.shub39.portfolio.pages.data.NavigateInfo
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.brands.Telegram
import compose.icons.fontawesomeicons.solid.Envelope
import compose.icons.fontawesomeicons.solid.Male
import compose.icons.fontawesomeicons.solid.Palette
import compose.icons.fontawesomeicons.solid.Tools
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.eclipse
import portfolio.composeapp.generated.resources.jetbrainsmono

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navigate: (Routes) -> Unit
) = PageFill {
    val uriHandler = LocalUriHandler.current
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(64.dp))

            Card(
                modifier = Modifier.padding(horizontal = 32.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val materialColor = MaterialTheme.colorScheme.tertiary
                    val colorMatrix = ColorMatrix().apply {
                        setToSaturation(0f)
                        val r = materialColor.red
                        val g = materialColor.green
                        val b = materialColor.blue
                        val a = materialColor.alpha
                        setToScale(r, g, b, a)
                    }

                    Image(
                        painter = painterResource(Res.drawable.eclipse),
                        contentDescription = "Eclipse",
                        colorFilter = ColorFilter.colorMatrix(
                            colorMatrix = colorMatrix
                        ),
                        modifier = Modifier
                            .padding(16.dp)
                            .size(150.dp)
                            .clip(CircleShape)
                    )

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
                            AssistChip(
                                modifier =  Modifier.padding(horizontal = 4.dp),
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

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.padding(horizontal = 32.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center
                ) {
                    listOf(
                        NavigateInfo(FontAwesomeIcons.Brands.Android, Routes.AppsPage, "Apps"),
                        NavigateInfo(FontAwesomeIcons.Solid.Tools, Routes.ProjectsPage, "Projects"),
                        NavigateInfo(FontAwesomeIcons.Solid.Male, Routes.AboutPage, "About"),
                        NavigateInfo(FontAwesomeIcons.Solid.Palette, Routes.ThemerPage, "Colors")
                    ).forEach { info ->
                        Button(
                            onClick = { navigate(info.route) },
                            modifier = Modifier.padding(4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            )
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = info.imageVector,
                                    contentDescription = info.title,
                                    modifier = Modifier.size(24.dp)
                                )

                                Text(
                                    text = info.title
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

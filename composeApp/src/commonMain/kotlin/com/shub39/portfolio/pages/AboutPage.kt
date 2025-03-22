package com.shub39.portfolio.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.util.PageFill
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Lastfm
import compose.icons.fontawesomeicons.brands.Spotify
import compose.icons.fontawesomeicons.brands.Youtube

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AboutPage(
    modifier: Modifier = Modifier
) = PageFill {
    val uriHandler = LocalUriHandler.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        item {
            Card(
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Hello :)",
                        style = MaterialTheme.typography.displaySmall
                    )

                    Text(
                        text = "I'm Shubham Gorai. I like to code stuff into existence. " +
                                "Other than that I also like to rate music, play games, " +
                                "test out bleeding edge stuff and nerd out about computer hardware" +
                                ". I aspire to learn the bass someday...",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    FlowRow(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        AssistChip(
                            onClick = { uriHandler.openUri("https://www.last.fm/user/shub39") },
                            label = { Text("LastFM") },
                            shape = CircleShape,
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                labelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                leadingIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = FontAwesomeIcons.Brands.Lastfm,
                                    contentDescription = "LastFM",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        )

                        AssistChip(
                            onClick = { uriHandler.openUri("https://open.spotify.com/user/31z7oxobdiwrat5belvf7biitlny?si=e1fcdbde14a64136") },
                            label = { Text("Spotify") },
                            shape = CircleShape,
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                                leadingIconContentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = FontAwesomeIcons.Brands.Spotify,
                                    contentDescription = "Spotify",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        )

                        AssistChip(
                            onClick = { uriHandler.openUri("https://www.youtube.com/@shub39") },
                            label = { Text("Youtube") },
                            shape = CircleShape,
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                labelColor = MaterialTheme.colorScheme.onTertiary,
                                leadingIconContentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = FontAwesomeIcons.Brands.Youtube,
                                    contentDescription = "Youtube",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
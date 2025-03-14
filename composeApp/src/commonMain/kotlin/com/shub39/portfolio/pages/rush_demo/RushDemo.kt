package com.shub39.portfolio.pages.rush_demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.darken
import com.materialkolor.ktx.lighten
import com.mikepenz.hypnoticcanvas.shaderBackground
import com.mikepenz.hypnoticcanvas.shaders.MeshGradient

@Composable
fun RushDemo(
    onBack: () -> Unit
) = Box(modifier = Modifier.fillMaxSize()) {
    var state by remember { mutableStateOf(LyricsPageState()) }

    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            contentColor = Color(state.mCardContent),
            containerColor = if (state.hypnoticCanvas) Color.Transparent else Color(state.mCardBackground)
        ),
        modifier = Modifier
            .fillMaxSize()
            .let {
                if (state.hypnoticCanvas) {
                    it.shaderBackground(
                        MeshGradient(
                            arrayOf(
                                Color(state.mCardBackground).lighten(2f),
                                Color(state.mCardBackground),
                                Color(state.mCardBackground).darken(2f)
                            )
                        ),
                        speed = state.meshSpeed
                    )
                } else {
                    it
                }
            }

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 500.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(64.dp))

                    Text(
                        text = state.song.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 2,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Text(
                        text = state.song.artists,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                    )

                    ActionsRow(
                        state = state,
                        editState = { state = it }
                    )

                    PlainLyrics(
                        state = state,
                        editState = { state = it }
                    )
                }
            }
        }
    }

    FloatingActionButton(
        onClick = onBack,
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(32.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close"
        )
    }
}
package com.shub39.portfolio.pages.rush_demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlainLyrics(
    state: LyricsPageState,
    editState: (LyricsPageState) -> Unit,
) {
    val hapticFeedback = LocalHapticFeedback.current

    LazyColumn(
        modifier = Modifier
            .widthIn(max = 500.dp)
            .fillMaxWidth()
            .padding(
                end = 16.dp,
                start = 16.dp,
                top = 16.dp,
                bottom = 32.dp
            )
    ) {
        items(state.song.lyrics, key = { it.key }) {
            if (it.value.isNotBlank()) {
                var isSelected = state.selectedLines.contains(it.key)
                val containerColor by animateColorAsState(
                    targetValue = when (!isSelected) {
                        true -> Color.Transparent
                        else -> Color(state.mCardContent).copy(alpha = 0.3f)
                    },
                    label = "container"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .padding(3.dp),
                        onClick = {
                            if (isSelected) {
                                editState(
                                    state.copy(
                                        selectedLines = state.selectedLines.minus(it.key)
                                    )
                                )
                                isSelected = false
                            } else {
                                editState(
                                    state.copy(
                                        selectedLines = state.selectedLines.plus(it.key to it.value)
                                    )
                                )
                                isSelected = true
                            }

                            if (!isSelected) {
                                hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                            }
                        },
                        shape = MaterialTheme.shapes.small,
                        colors = CardDefaults.cardColors(
                            containerColor = containerColor,
                            contentColor = Color(state.mCardContent)
                        )
                    ) {
                        Text(
                            text = it.value,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }
            }
        }
    }
}
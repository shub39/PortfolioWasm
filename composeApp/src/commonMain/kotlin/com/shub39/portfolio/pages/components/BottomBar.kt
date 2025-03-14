package com.shub39.portfolio.pages.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.shub39.portfolio.Routes
import com.shub39.portfolio.pages.data.NavigateInfo

@Composable
fun BottomBar(
    navigate: (Routes) -> Unit,
    list: List<NavigateInfo>
) {
    BottomAppBar(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            list.forEach { info ->
                ExpandingIconButton(
                    onClick = { navigate(info.route) },
                    tooltip = info.title
                ) {
                    Icon(
                        imageVector = info.imageVector,
                        contentDescription = info.title,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
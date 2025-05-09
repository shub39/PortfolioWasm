package com.shub39.portfolio.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@Composable
fun ColorPickerDialog(
    initialColor: Color,
    onSelect: (Color) -> Unit,
    onDismiss: () -> Unit
) {
    val controller = rememberColorPickerController()

    Dialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            modifier = Modifier.widthIn(max = 500.dp)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                HsvColorPicker(
                    modifier = Modifier
                        .width(350.dp)
                        .height(300.dp)
                        .padding(top = 10.dp),
                    initialColor = initialColor,
                    controller = controller
                )

                BrightnessSlider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(35.dp),
                    initialColor = initialColor,
                    controller = controller
                )

                AlphaTile(
                    modifier = Modifier
                        .size(80.dp)
                        .padding(vertical = 10.dp),
                    controller = controller
                )

                Button(
                    onClick = {
                        onSelect(controller.selectedColor.value)
                        onDismiss()
                    }
                ) {
                    Text(
                        text = "Done",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
package com.blackwhitecircle.depo.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun StatusLine(
    text: String,
    color: Color
) {

    Text(
        text = text,
        color = color,
        fontWeight = FontWeight.Bold
    )

}
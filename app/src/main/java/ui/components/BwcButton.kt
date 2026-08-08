package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.border
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BwcButton(

    text: String,

    onClick: () -> Unit

) {

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(1.dp, Color.DarkGray)
            )
            .clickable {
                onClick()
            }
            .padding(vertical = 14.dp),

        contentAlignment = Alignment.Center

    ) {

        Text(

            text = text,

            color = Color.White,

            fontSize = 18.sp,

            fontWeight = FontWeight.Medium

        )

    }

}
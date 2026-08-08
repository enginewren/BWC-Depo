package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BwcSwitch(

    checked: Boolean,

    onCheckedChange: (Boolean) -> Unit

) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(

            text = if (checked) "●" else "○",

            color = if (checked) Color.Green
            else Color.Gray,

            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .clickable {

                    onCheckedChange(!checked)

                }

        )

    }

}
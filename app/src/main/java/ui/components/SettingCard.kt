package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SettingCard(

    title: String,

    content: @Composable () -> Unit

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)

    ) {

        Text(

            text = title,

            color = Color.White,

            fontSize = 20.sp,

            fontWeight = FontWeight.Bold

        )

        content()

    }

}
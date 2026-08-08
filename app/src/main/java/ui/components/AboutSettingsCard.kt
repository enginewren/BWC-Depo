package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AboutSettingsCard() {

    Text(
        text = "Warehouse Management System",
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(16.dp))

    InfoItem("Version", "v0.9.0 Demo")
    InfoItem("Build", "20260807.001")
    InfoItem("Developer", "Engin Evren")
    InfoItem("Powered by", "BlackWhiteCircle™")

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "© 2026 Engin Evren",
        color = Color.Gray,
        fontSize = 12.sp
    )

    Text(
        text = "Made in Türkiye 🇹🇷",
        color = Color.Gray,
        fontSize = 12.sp
    )
}

@Composable
private fun InfoItem(
    title: String,
    value: String
) {

    Column {

        Text(
            text = title,
            color = Color.Gray
        )

        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(10.dp))
    }

}
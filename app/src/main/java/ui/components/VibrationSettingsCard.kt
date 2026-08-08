package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VibrationSettingsCard() {

    var vibrationEnabled by remember { mutableStateOf(true) }
    var strongVibration by remember { mutableStateOf(false) }

    Text(
        text = "Titreşim ayarlarını buradan yönetebilirsiniz.",
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(16.dp))

    SettingToggleItem(
        title = "Titreşim Aktif",
        checked = vibrationEnabled
    ) {
        vibrationEnabled = it
    }

    Spacer(modifier = Modifier.height(12.dp))

    SettingToggleItem(
        title = "Güçlü Titreşim",
        checked = strongVibration
    ) {
        strongVibration = it
    }
}
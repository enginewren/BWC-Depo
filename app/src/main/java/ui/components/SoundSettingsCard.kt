package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SoundSettingsCard() {

    var buttonSound by remember { mutableStateOf(true) }
    var successSound by remember { mutableStateOf(true) }
    var errorSound by remember { mutableStateOf(true) }

    Text(
        text = "Uygulama seslerini buradan yönetebilirsiniz.",
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(16.dp))

    SettingToggleItem(
        title = "Buton Sesi",
        checked = buttonSound
    ) {
        buttonSound = it
    }

    Spacer(modifier = Modifier.height(12.dp))

    SettingToggleItem(
        title = "Başarı Sesi",
        checked = successSound
    ) {
        successSound = it
    }

    Spacer(modifier = Modifier.height(12.dp))

    SettingToggleItem(
        title = "Hata Sesi",
        checked = errorSound
    ) {
        errorSound = it
    }
}
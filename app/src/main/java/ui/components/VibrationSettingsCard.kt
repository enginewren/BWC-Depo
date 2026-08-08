package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.blackwhitecircle.depo.data.preferences.PreferencesManager

@Composable
fun VibrationSettingsCard() {

    val context = LocalContext.current
    val prefs = remember { PreferencesManager(context) }

    var vibrationEnabled by remember {
        mutableStateOf(
            prefs.getBoolean(
                PreferencesManager.VIBRATION,
                true
            )
        )
    }

    var strongVibration by remember {
        mutableStateOf(
            prefs.getBoolean(
                PreferencesManager.STRONG_VIBRATION,
                false
            )
        )
    }

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
        prefs.setBoolean(
            PreferencesManager.VIBRATION,
            it
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    SettingToggleItem(
        title = "Güçlü Titreşim",
        checked = strongVibration
    ) {
        strongVibration = it
        prefs.setBoolean(
            PreferencesManager.STRONG_VIBRATION,
            it
        )
    }
}
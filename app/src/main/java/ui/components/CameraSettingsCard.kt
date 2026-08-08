package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.blackwhitecircle.depo.data.preferences.PreferencesManager

@Composable
fun CameraSettingsCard() {

    val context = LocalContext.current
    val prefs = remember { PreferencesManager(context) }
    var autoZoom by remember {
        mutableStateOf(
            prefs.getBoolean(
                PreferencesManager.AUTO_ZOOM,
                true
            )
        )
    }
    var flash by remember { mutableStateOf(false) }

    var sound by remember {
        mutableStateOf(
            prefs.getBoolean(
                PreferencesManager.BARCODE_SOUND,
                true
            )
        )
    }

    Text(
        text = "Tarama sırasında kullanılacak ayarlar.",
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(16.dp))




    SettingToggleItem(
        "Otomatik Zoom",
        autoZoom
    ) {
        autoZoom = it
        prefs.setBoolean(
            PreferencesManager.AUTO_ZOOM,
            it
        )
    }

    Spacer(Modifier.height(12.dp))

    SettingToggleItem(
        "Flaş",
        flash
    ) {
        flash = it
    }

    Spacer(Modifier.height(12.dp))

    SettingToggleItem(
        "Barkod Sesi",
        sound
    ) {
        sound = it

        prefs.setBoolean(
            PreferencesManager.BARCODE_SOUND,
            it
        )
    }
}

package com.blackwhitecircle.depo.data.preferences

import android.content.Context

class PreferencesManager(context: Context) {

    private val prefs =
        context.getSharedPreferences("bwc_depo", Context.MODE_PRIVATE)

    companion object {
        const val AUTO_ZOOM = "auto_zoom"
        const val FLASH = "flash"
        const val BARCODE_SOUND = "barcode_sound"
        const val BUTTON_SOUND = "button_sound"
        const val SUCCESS_SOUND = "success_sound"
        const val ERROR_SOUND = "error_sound"
        const val VIBRATION = "vibration"
        const val STRONG_VIBRATION = "strong_vibration"
    }

    fun setBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, default: Boolean): Boolean {
        return prefs.getBoolean(key, default)
    }
}
package com.blackwhitecircle.depo.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import com.blackwhitecircle.depo.data.preferences.PreferencesManager

object VibrationHelper {

    fun vibrate(context: Context) {

        val prefs = PreferencesManager(context)

        val enabled = prefs.getBoolean(
            PreferencesManager.VIBRATION,
            true
        )

        if (!enabled) return

        val strong = prefs.getBoolean(
            PreferencesManager.STRONG_VIBRATION,
            false
        )

        val vibrator =
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val duration =
                if (strong) 150L else 50L

            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    duration,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )

        } else {

            @Suppress("DEPRECATION")
            vibrator.vibrate(
                if (strong) 150 else 50
            )

        }
    }
}
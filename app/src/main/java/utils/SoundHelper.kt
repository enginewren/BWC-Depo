package com.blackwhitecircle.depo.ui.utils

import android.media.AudioManager
import android.media.ToneGenerator

object SoundHelper {

    fun playSuccess() {

        ToneGenerator(
            AudioManager.STREAM_NOTIFICATION,
            100
        ).startTone(
            ToneGenerator.TONE_PROP_BEEP,
            150
        )

    }
}
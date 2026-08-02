package com.blackwhitecircle.depo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.blackwhitecircle.depo.ui.theme.BWCDepoTheme
import com.blackwhitecircle.depo.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BWCDepoTheme {

                AppNavigation()

            }

        }
    }
}


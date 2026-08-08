package com.blackwhitecircle.depo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.blackwhitecircle.depo.ui.components.CommandBar
import android.os.VibrationEffect
import android.os.Vibrator
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.fillMaxWidth

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Header()

            Spacer(modifier = Modifier.weight(1f))

            Column {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.DarkGray)
                )

                CommandBar(
                    leftText = "GİR",
                    centerText = "OKUT",
                    rightText = "AYAR",

                    onLeftClick = {

                    },

                    onCenterClick = {

                        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            vibrator.vibrate(
                                VibrationEffect.createWaveform(
                                    longArrayOf(0, 60, 40, 60),
                                    -1
                                )
                            )
                        }

                        navController.navigate("scanner")
                    },

                    onRightClick = {

                        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            vibrator.vibrate(
                                VibrationEffect.createWaveform(
                                    longArrayOf(0, 40),
                                    -1
                                )
                            )
                        }

                        navController.navigate("settings")

                    }
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.DarkGray)
                )
            }
        }

    }

}

@Composable
private fun Header() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "BWC DEPO",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

    }

}
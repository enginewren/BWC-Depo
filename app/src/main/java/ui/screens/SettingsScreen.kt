package com.blackwhitecircle.depo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.blackwhitecircle.depo.ui.components.SectionDivider
import com.blackwhitecircle.depo.ui.components.SettingCard
import com.blackwhitecircle.depo.ui.components.BwcButton
import com.blackwhitecircle.depo.ui.components.ServerSettingsCard
import com.blackwhitecircle.depo.ui.components.CameraSettingsCard
import com.blackwhitecircle.depo.ui.components.SoundSettingsCard
import com.blackwhitecircle.depo.ui.components.AboutSettingsCard
import com.blackwhitecircle.depo.ui.components.UserGuideCard
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.blackwhitecircle.depo.ui.components.VibrationSettingsCard

@Composable
fun SettingsScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {

            Text(
                text = "AYARLAR",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            SectionDivider()

            Spacer(modifier = Modifier.height(20.dp))

            SettingCard(
                title = "SUNUCU"
            ) {

                ServerSettingsCard()

            }
            Spacer(modifier = Modifier.height(20.dp))

            SectionDivider()

            Spacer(modifier = Modifier.height(20.dp))

            SettingCard(
                title = "KAMERA"
            ) {

                CameraSettingsCard()

            }
            Spacer(modifier = Modifier.height(20.dp))

            SectionDivider()

            Spacer(modifier = Modifier.height(20.dp))

            SettingCard(
                title = "SES"
            ) {
                SoundSettingsCard()
            }
            Spacer(modifier = Modifier.height(20.dp))


            SectionDivider()

            Spacer(modifier = Modifier.height(20.dp))

            SettingCard(
                title = "TİTREŞİM"
            ) {
                VibrationSettingsCard()
            }
            Spacer(modifier = Modifier.height(20.dp))

            SectionDivider()

            SettingCard(

                title = "HAKKINDA"
            ) {
                AboutSettingsCard()
            }


            Spacer(modifier = Modifier.height(20.dp))

            SettingCard(
                title = "KULLANIM KILAVUZU"
            ) {
                UserGuideCard()
            }
        }
    }
}
package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CommandBar(
    modifier: Modifier = Modifier,
    leftText: String,
    centerText: String,
    rightText: String,
    enabled: Boolean = true,
    onLeftClick: () -> Unit = {},
    onCenterClick: () -> Unit = {},
    onRightClick: () -> Unit = {}
) {

    Column(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp,)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = leftText,
                    color = if (enabled) Color.White else Color.Gray,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 24.dp)
                        .clickable(enabled = enabled) {
                            onLeftClick()
                        }
                )

                Text(
                    text = centerText,
                    color = if (enabled) Color.White else Color.Gray,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable(enabled = enabled) {
                            onCenterClick()
                        }
                )

                Text(
                    text = rightText,
                    color = if (enabled) Color.White else Color.Gray,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 24.dp)
                        .clickable(enabled = enabled) {
                            onRightClick()
                        }
                )
            }
        }
    }
}
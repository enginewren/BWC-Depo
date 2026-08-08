package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SettingToggleItem(

    title: String,

    checked: Boolean,

    onCheckedChange: (Boolean) -> Unit

) {

    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically

    ) {

        Text(

            text = title,

            color = Color.White

        )

        BwcSwitch(

            checked = checked,

            onCheckedChange = onCheckedChange

        )

    }

}
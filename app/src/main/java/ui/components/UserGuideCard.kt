package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UserGuideCard() {

    Text(
        text = "Uygulamanın temel kullanım adımlarını buradan görüntüleyebilirsiniz.",
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(16.dp))

    BwcButton(
        text = "KILAVUZU AÇ",
        onClick = {
            // Şimdilik boş bırakacağız.
        }
    )
}
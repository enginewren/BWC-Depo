/*
--------------------------------------------------------
BWC DEPO
PrimaryActionButton.kt

Reusable full-width primary action button.
Black / white / gray industrial style only.
No icon, no animation, no gradient, no Material ripple styling.

Used by: ProductScreen (KAYDET).
Reused later by: SearchScreen, CountScreen action buttons.

Developer : Engin Evren
Architecture : Jetpack Compose
BlackWhiteCircle
--------------------------------------------------------
*/

package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Tam genişlikte birincil aksiyon butonu.
 *
 * @param enabled false ise buton koyu gri görünür ve tıklanamaz.
 * İleride API bağlanana kadar veya validasyon geçmeden pasif tutmak için kullanılabilir.
 */
@Composable
fun PrimaryActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(if (enabled) Color.White else Color.DarkGray)
            .clickable(enabled = enabled) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
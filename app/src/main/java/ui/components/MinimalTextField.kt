/*
--------------------------------------------------------
BWC DEPO
MinimalTextField.kt

Reusable minimal input field.
No card, no fill background, no Material default styling.
Industrial terminal look: label + underline only.

Used by: ProductScreen (ADET / KOLİ / PALET, and future fields).
Reused later by: SearchScreen, CountScreen.

Developer : Engin Evren
Architecture : Jetpack Compose
BlackWhiteCircle
--------------------------------------------------------
*/

package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

/**
 * Minimal, kart görünümü olmayan giriş alanı.
 *
 * @param label Alan başlığı (örn. "ADET", "KOLİ", "PALET")
 * @param value Güncel değer
 * @param onValueChange Değer değiştiğinde tetiklenir
 * @param keyboardType Varsayılan Number; ileride SKT gibi tarih alanları için
 * Text/farklı klavye tipleriyle de kullanılabilir.
 */
@Composable
fun MinimalTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    focusRequester: FocusRequester = FocusRequester()
) {
    Column(modifier = modifier) {

        Text(
            text = label,
            color = Color.White.copy(alpha = 0.85f),
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(1.dp))

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 20.sp
            ),
            cursorBrush = SolidColor(Color.White),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),

            keyboardActions = keyboardActions,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)

        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.DarkGray)
        )
    }
}
package com.blackwhitecircle.depo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.net.Uri

@Composable
fun ProductScreen(

    barkod: String,
    urunKodu: String,
    urunAdi: String,
    birim: String

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)

    ) {

        Text(
            "ÜRÜN",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(30.dp))

        ProductItem("BARKOD", barkod)
        ProductItem("ÜRÜN KODU", urunKodu)
        ProductItem(
            "ÜRÜN ADI",
            Uri.decode(urunAdi)
        )
        ProductItem("BİRİM", birim)

    }

}

@Composable
private fun ProductItem(

    title: String,
    value: String

) {

    Column {

        Text(
            title,
            color = Color.Gray,
            fontSize = 14.sp
        )

        Text(
            value,
            color = Color.White,
            fontSize = 22.sp
        )

        Spacer(Modifier.height(18.dp))

    }

}
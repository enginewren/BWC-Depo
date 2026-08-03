/*
--------------------------------------------------------
BWC DEPO
ProductScreen.kt

Barkod okunduktan sonra gösterilen ürün ekranı.
Üstte salt-okunur ürün bilgileri (BARKOD / ÜRÜN KODU / ÜRÜN ADI / BİRİM),
altta stok giriş alanları ve KAYDET aksiyonu.

Genişletilebilirlik notu:
Giriş alanları `quantityFields` listesi üzerinden data-driven olarak
render edilir. İleride PALETTE KOLİ, KOLİ İÇİ, EK ADET, ÜRETİM, SKT,
DEPO, CEPHE, CEPHE NO, SIRA gibi yeni alanlar eklenecek. Bunun için
tek yapılması gereken bu listeye yeni bir QuantityField eklemektir;
UI, state ve KAYDET akışı otomatik olarak yeni alanı da kapsar.

Developer : Engin Evren
Architecture : Jetpack Compose
BlackWhiteCircle
--------------------------------------------------------
*/

package com.blackwhitecircle.depo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.net.Uri
import androidx.compose.ui.text.input.KeyboardType
import com.blackwhitecircle.depo.ui.components.MinimalTextField
import com.blackwhitecircle.depo.ui.components.PrimaryActionButton
import com.blackwhitecircle.depo.network.RetrofitClient
import com.blackwhitecircle.depo.network.SaveResponse
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.navigation.NavController
import com.blackwhitecircle.depo.ui.components.CommandBar

/**
 * Stok giriş alanı tanımı.
 *
 * @param key Alanın state map'indeki benzersiz anahtarı (KAYDET akışında bu key kullanılacak).
 * @param label Ekranda görünen başlık.
 * @param keyboardType Şimdilik tüm alanlar sayısal; SKT gibi ileride eklenecek
 * tarih alanları için farklı bir keyboardType verilebilir.
 */
private data class QuantityField(
    val key: String,
    val label: String,
    val keyboardType: KeyboardType = KeyboardType.Number

)

/**
 * Şu an aktif giriş alanları.
 *
 * İleride eklenecek (henüz eklenmedi, sadece referans için):
 * QuantityField("paletteKoli", "PALETTE KOLİ")
 * QuantityField("koliIci", "KOLİ İÇİ")
 * QuantityField("ekAdet", "EK ADET")
 * QuantityField("uretim", "ÜRETİM")
 * QuantityField("skt", "SKT")
 * QuantityField("depo", "DEPO")
 * QuantityField("cephe", "CEPHE")
 * QuantityField("cepheNo", "CEPHE NO")
 * QuantityField("sira", "SIRA")
 */
private val quantityFields = listOf(
    QuantityField("adet", "ADET"),
    QuantityField("koli", "KOLİ"),
    QuantityField("palet", "PALET")
)

@Composable
fun ProductScreen(
navController: NavController,
barkod: String,
urunKodu: String,
urunAdi: String,
birim: String
) {

    var fieldValues by remember {
        mutableStateOf(quantityFields.associate { it.key to "" })

    }
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
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

        Spacer(Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.DarkGray)
        )

        Spacer(Modifier.height(8.dp))

        quantityFields.forEach { field ->

            MinimalTextField(
                label = field.label,
                value = fieldValues[field.key] ?: "",
                onValueChange = { newValue ->
                    fieldValues = fieldValues.toMutableMap().apply {
                        this[field.key] = newValue
                    }
                },
                keyboardType = field.keyboardType,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

        }

        Spacer(Modifier.height(8.dp))

        CommandBar(
            leftText = "GERİ",
            centerText = "KAYDET",
            rightText = "İPTAL",

            onLeftClick = {
                navController.popBackStack()
            },

            onCenterClick = {
                kaydet(
                    navController = navController,
                    context = context,
                    barkod = barkod,
                    urunKodu = urunKodu,
                    urunAdi = Uri.decode(urunAdi),
                    birim = birim,
                    fieldValues = fieldValues
                )
            },

            onRightClick = {
                navController.popBackStack()
            }
        )

        Spacer(Modifier.height(12.dp))

    }

}

/**
 * KAYDET akışı iskeleti.
 *
 * TODO: Apps Script action="kaydet"
 * API hazır olduğunda burada RetrofitClient.api.kaydet(...) çağrısı yapılacak
 * (suspend fonksiyona ve ViewModel/Repository katmanına taşınarak).
 * Şu an için hiçbir network çağrısı yapılmıyor; sadece iskelet.
 */
private fun kaydet(
    navController: NavController,
    context: Context,
    barkod: String,
    urunKodu: String,
    urunAdi: String,
    birim: String,
    fieldValues: Map<String, String>
){

    RetrofitClient.api.kaydet(
        barkod = barkod,
        urunKodu = urunKodu,
        urunAdi = urunAdi,
        birim = birim,
        adet = fieldValues["adet"] ?: "",
        koli = fieldValues["koli"] ?: "",
        palet = fieldValues["palet"] ?: ""
    ).enqueue(object : retrofit2.Callback<SaveResponse> {

        override fun onResponse(
            call: retrofit2.Call<SaveResponse>,
            response: retrofit2.Response<SaveResponse>
        ) {
            Toast.makeText(

                context,
                "Kaydedildi",
                Toast.LENGTH_SHORT
            ).show()
            navController.popBackStack()
        }

        override fun onFailure(
            call: retrofit2.Call<SaveResponse>,
            t: Throwable
        ) {
        }

    })
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

        Spacer(Modifier.height(10.dp))

    }

}
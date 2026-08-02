package com.blackwhitecircle.depo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.blackwhitecircle.depo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ScannerScreen(
    navController: NavHostController
) {

    val context = LocalContext.current

    val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_ALL_FORMATS
        )
        .enableAutoZoom()
        .build()

    val scanner = GmsBarcodeScanning.getClient(
        context,
        options
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        LaunchedEffect(Unit) {

            scanner.startScan()
                .addOnSuccessListener { barcode ->

                    val barkod = barcode.rawValue ?: return@addOnSuccessListener

                    RetrofitClient.api.urunAra(
                        action = "urunAra",
                        barkod = barkod
                    )
                        .enqueue(object : Callback<com.blackwhitecircle.depo.network.UrunResponse> {

                            override fun onResponse(
                                call: Call<com.blackwhitecircle.depo.network.UrunResponse>,
                                response: Response<com.blackwhitecircle.depo.network.UrunResponse>
                            ) {

                                val urun = response.body()

                                if (urun != null && urun.success) {

                                    navController.navigate(

                                        "product/" +
                                                barkod + "/" +
                                                (urun.urunKodu ?: "") + "/" +
                                                android.net.Uri.encode(urun.urunAdi ?: "") + "/" +
                                                (urun.birim ?: "")

                                    )

                                } else {

                                    Toast.makeText(
                                        context,
                                        "Ürün bulunamadı",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                }

                                navController.popBackStack()

                            }

                            override fun onFailure(
                                call: Call<com.blackwhitecircle.depo.network.UrunResponse>,
                                t: Throwable
                            ) {

                                Toast.makeText(
                                    context,
                                    t.message,
                                    Toast.LENGTH_LONG
                                ).show()

                                navController.popBackStack()

                            }

                        })

                }
                .addOnCanceledListener {

                    navController.popBackStack()

                }
                .addOnFailureListener {

                    Toast.makeText(
                        context,
                        it.message ?: "Hata",
                        Toast.LENGTH_SHORT
                    ).show()

                    navController.popBackStack()

                }

        }


    }

}
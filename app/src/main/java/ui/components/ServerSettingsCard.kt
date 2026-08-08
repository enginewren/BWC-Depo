package com.blackwhitecircle.depo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.blackwhitecircle.depo.network.RetrofitClient
import com.blackwhitecircle.depo.network.SaveResponse
import com.blackwhitecircle.depo.network.ServerRepository

@Composable

fun ServerSettingsCard() {
    var statusText by remember {
        mutableStateOf("● Kontrol Edilmedi")
    }
    var statusColor by remember { mutableStateOf(Color.Gray) }

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        text = "Durum",
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
        text = statusText,
        color = statusColor
    )

    Spacer(modifier = Modifier.height(20.dp))

    BwcButton(
        text = "BAĞLANTIYI TEST ET"
    ) {

        statusText = "Bağlanıyor..."
        statusColor = Color.Yellow

        ServerRepository.ping().enqueue(object : Callback<SaveResponse> {

            override fun onResponse(
                call: Call<SaveResponse>,
                response: Response<SaveResponse>
            ) {

                if (response.isSuccessful && response.body()?.success == true) {

                    statusText = "● Sunucu Aktif"
                    statusColor = Color.Green

                } else {

                    statusText = "● Sunucu Hatası"
                    statusColor = Color.Red

                }
            }

            override fun onFailure(
                call: Call<SaveResponse>,
                t: Throwable
            ) {

                statusText = "● Bağlantı Yok"
                statusColor = Color.Red

            }

        })

    }

}
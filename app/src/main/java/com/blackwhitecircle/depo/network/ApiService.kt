package com.blackwhitecircle.depo.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("exec")
    fun urunAra(
        @Query("action") action: String = "urunAra",
        @Query("barkod") barkod: String
    ): Call<UrunResponse>
    @GET("exec")
    fun kaydet(
        @Query("action") action: String = "kaydet",
        @Query("barkod") barkod: String,
        @Query("urunKodu") urunKodu: String,
        @Query("urunAdi") urunAdi: String,
        @Query("birim") birim: String,
        @Query("adet") adet: String,
        @Query("koli") koli: String,
        @Query("palet") palet: String
    ): Call<SaveResponse>

}
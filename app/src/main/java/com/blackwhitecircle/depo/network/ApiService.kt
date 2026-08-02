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

}
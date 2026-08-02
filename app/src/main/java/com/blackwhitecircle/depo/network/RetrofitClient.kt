package com.blackwhitecircle.depo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "https://script.google.com/macros/s/AKfycbzbML-e9eS7qiS0_NNJBZmidk3tQQix51SBo6HBqQfOdW7HpniQ7rrSbvBT4-IaOliC/"

    val api: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

}
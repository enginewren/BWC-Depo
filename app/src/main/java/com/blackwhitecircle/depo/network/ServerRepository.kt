package com.blackwhitecircle.depo.network

import retrofit2.Call

object ServerRepository {

    fun ping(): Call<SaveResponse> {
        return RetrofitClient.api.ping()
    }

}
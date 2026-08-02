package com.blackwhitecircle.depo.network

data class UrunResponse(

    val success: Boolean,

    val barkod: String?,

    val urunKodu: String?,

    val urunAdi: String?,

    val birim: String?,

    val message: String?

)
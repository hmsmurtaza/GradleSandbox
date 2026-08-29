package com.android.example.network

import retrofit2.Retrofit

class NetworkClient {
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
    }
}
package com.example.network

import com.example.network.data.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {
    @GET("/v1/images/search")
    suspend fun getAllCats(
        @Query("limit") limit: Int = 1, @Query("api_key") api_key: String = BuildConfig.apiKey
    ): Response<List<Cat>>
}
package com.example.network

import com.example.example.ApiRoot
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {
//    @GET("/search")
    @GET("/v1/images/search")
    suspend fun getAllCats(
//        @Query("excluded_tags") excluded_tags: String = "milf",
//        @Query("excluded_tags") second: String = "paizuri",
//        @Query("included_tags")included_tag: String = "waifu",
//        @Query("many") manu: Boolean = false,
//        @Query("is_nsfw") is_nsfw:Boolean=false,
//        @Query("included_tags") first: String = "ass",
//        @Query("included_tags") second: String="hentai",
//        @Query("orientation") orientation: String = "PORTRAIT"

        @Query("limit") limit: Int = 1, @Query("api_key") api_key: String = BuildConfig.apiKey
    ): Response<ApiRoot>
}
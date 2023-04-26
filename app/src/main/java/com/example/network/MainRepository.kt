package com.example.network

class MainRepository constructor(private val retrofitService: RetrofitService){
    suspend fun getAllCats()=retrofitService.getAllCats()
}
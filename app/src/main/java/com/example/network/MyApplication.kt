package com.example.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    lateinit var retrofitService: RetrofitService

    override fun onCreate() {
        super.onCreate()
        getInstance()
    }

    fun getInstance() {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitService = retrofit.create(RetrofitService::class.java)
    }

}

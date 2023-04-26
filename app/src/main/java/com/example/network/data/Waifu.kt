package com.example.network.data

import com.google.gson.annotations.SerializedName
//data class Cat(@SerializedName ("id") val id: String,
//              @SerializedName("url") val imageUrl: String)

data class Waifu(@SerializedName ("image_id") val id: Int,
                 @SerializedName("url") val imageUrl: String)
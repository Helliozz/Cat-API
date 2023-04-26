package com.example.example

import com.example.network.data.Waifu
import com.google.gson.annotations.SerializedName


data class ApiRoot (
  @SerializedName("images" ) var images : List<Waifu> = arrayListOf()
)
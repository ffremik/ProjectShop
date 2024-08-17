package com.example.projectmoon.view.home.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val shopRetrofit = Retrofit.Builder()
    .baseUrl(URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface InteractionsRetrofit{
    @GET("realestate")
    suspend fun getAllItemsShop(): List<Items>
}

object ShopApi{
    val interactionsRetrofit: InteractionsRetrofit by lazy {
        shopRetrofit.create(InteractionsRetrofit::class.java)
    }
}
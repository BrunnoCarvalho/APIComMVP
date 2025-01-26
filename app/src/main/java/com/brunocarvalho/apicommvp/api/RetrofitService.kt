package com.brunocarvalho.apicommvp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    const val URL = "https://jsonplaceholder.typicode.com/"

    fun getJsonPlace(): JsonPlaceAPI{

        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceAPI::class.java)
    }

}
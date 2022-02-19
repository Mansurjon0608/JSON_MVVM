package com.example.jsonplace

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    val BASEURL = "https://jsonplaceholder.typicode.com/"
    fun    getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}
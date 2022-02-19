package com.example.jsonplace

import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {

    @GET("posts/1")
    fun getAllPosts(): Call<JsonPlaceItem>
}
package com.example.jsonplace

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    companion object {
        private var postsPeople: MutableLiveData<JsonPlaceItem> = MutableLiveData()
        val apiClient = ApiService()
        val retrofit = apiClient.getRetrofit()
        val apiService = retrofit.create(ApiRequest::class.java)


        fun getAllPosts(): MutableLiveData<JsonPlaceItem> {
            apiService.getAllPosts().enqueue(object : Callback<JsonPlaceItem> {
                override fun onResponse(
                    call: Call<JsonPlaceItem>,
                    response: Response<JsonPlaceItem>
                ) {
                    if (response.isSuccessful) {
                        val json = response.body()
                        postsPeople.postValue(json)

                    }
                }

                override fun onFailure(call: Call<JsonPlaceItem>, t: Throwable) {
                    Log.v("JsonPlaceView","${t}")
                }

            })

            return postsPeople
        }
    }

}
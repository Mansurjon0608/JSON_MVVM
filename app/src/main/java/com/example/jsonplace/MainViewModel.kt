package com.example.jsonplace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    private var postLiveData: MutableLiveData<JsonPlaceItem> = MutableLiveData()

    fun getAllPost(): LiveData<JsonPlaceItem> {
        postLiveData = MainRepository.getAllPosts()
        return postLiveData
    }
}
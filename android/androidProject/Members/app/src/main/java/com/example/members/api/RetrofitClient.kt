package com.example.members.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private val client = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val  userApi:UsersApi = client.create(UsersApi::class.java)
        val postsApi:PostsApi = client.create(PostsApi::class.java)
    }
}
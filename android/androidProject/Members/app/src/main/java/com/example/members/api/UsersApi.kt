package com.example.members.api

import com.example.members.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApi {

    @GET("users")
    fun getUser(): Call<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("id") id:Int): Call<User>
}
package com.example.members.api

import com.example.members.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id:Int) : Call<Post>

    @GET("posts")
    fun getPostsByUserId(@Query("userId") userId:Int) : Call<List<Post>>
}
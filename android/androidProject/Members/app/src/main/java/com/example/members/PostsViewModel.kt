package com.example.members

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.members.api.RetrofitClient
import com.example.members.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel : ViewModel() {
    val posts = MutableLiveData<List<Post>>()

    fun getPosts(userId:Int) = viewModelScope.launch(Dispatchers.IO){
        RetrofitClient.postsApi.getPostsByUserId(userId).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.code() == 200){
                    Log.i("Http", "${response.body()}")
                    posts.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}
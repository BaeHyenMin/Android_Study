package com.example.members

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.members.databinding.ActivityPostsBinding
import com.example.members.widget.PostAdapter

class PostsActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityPostsBinding.inflate(layoutInflater)
    }

    private val viewModel : PostsViewModel by viewModels()

    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerViewPosts.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPosts.adapter = adapter

        viewModel.posts.observe(this){
            adapter.updateData(it)
        }

        val userId = intent.getIntExtra("userId", 1)
        viewModel.getPosts(userId)

    }

}
package com.example.members

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.members.databinding.ActivityMainBinding
import com.example.members.widget.UserAdapter

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel:MainViewModel by viewModels()

    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewUsers.adapter = adapter

        adapter.addListener {
            val intent = Intent(this, PostsActivity::class.java).apply {
                putExtra("userId", it.id)
            }
            startActivity(intent)
        }

        viewModel.users.observe(this){
            adapter.updateData(it)
        }

        viewModel.getUsers()
    }
}
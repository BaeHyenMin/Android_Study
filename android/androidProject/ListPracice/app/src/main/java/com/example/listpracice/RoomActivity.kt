package com.example.listpracice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listpracice.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRoomBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textViewName.text = intent.getStringExtra("name")
    }
}
package com.example.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.count.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        viewModel.count.observe(this){binding.textViewCount.text = "$it"}

        binding.buttonCount.setOnClickListener {
            addCount()
        }

    }


    private fun addCount(){
        viewModel.count.value = viewModel.count.value?.plus(1);
    }

}
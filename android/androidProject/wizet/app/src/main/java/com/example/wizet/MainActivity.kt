package com.example.wizet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.wizet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val watcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        biding.switch2.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) biding.progressBar.visibility = View.VISIBLE
            else biding.progressBar.visibility = View.INVISIBLE
        }
    }
}
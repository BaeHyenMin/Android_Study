package com.example.register

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.register.databinding.ActivityCourseBinding

class CourseActivity : AppCompatActivity() {

    private val biding by lazy{
        ActivityCourseBinding.inflate(layoutInflater)
    }

    private val requestPhoto = registerForActivityResult(ActivityResultContracts.GetContent()){
        biding.imageView2.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        setResult(Activity.RESULT_CANCELED)

        biding.textViewName.text = intent.getStringExtra("name")
        biding.textViewType.text = intent.getStringExtra("type")


        biding.buttonOk.setOnClickListener {
            val data = Intent()
            data.putExtra("value", "Hello!")
            setResult(Activity.RESULT_OK, data)
            finish()

        }

        biding.buttonPhoto.setOnClickListener {
            requestPhoto.launch(("image/*"))
        }

        biding.buttonCancel.setOnClickListener { finish() }




        if(intent.type?.startsWith("image/")==true){
            val uri = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
            else
                intent.getParcelableExtra(Intent.EXTRA_STREAM) as? Uri

            biding.imageView2.setImageURI(uri)
        }
    }
}
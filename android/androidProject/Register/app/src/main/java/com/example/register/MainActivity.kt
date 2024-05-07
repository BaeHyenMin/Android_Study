package com.example.register

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.register.databinding.ActivityMainBinding
import java.lang.Exception

class MyCycle:DefaultLifecycleObserver{


    override fun onStart(owner: LifecycleOwner) {
        Log.i("MainActivity", "MyCycle-started")
        super.onStart(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i("MainActivity", "MyCycle-stop")
        super.onStop(owner)
    }



}


class MainActivity : AppCompatActivity() {

    val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    val wathcer = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
           updatePrograss()
        }

    }

    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val result = it.resultCode
            if(it.data != null){
                Log.i("MainActivity", "${it.data!!.getStringExtra("value")}")
            }
            Log.i("MainActivity", "$result")
        }

    private lateinit var myCycle: MyCycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        myCycle = MyCycle()
        lifecycle.addObserver(myCycle)


        biding.editTextTextPersonName.addTextChangedListener(wathcer)
        biding.editTextPhone.addTextChangedListener(wathcer)
        biding.radioButtonAdult.setOnClickListener{updatePrograss()}
        biding.radioButtonStudent.setOnClickListener{updatePrograss()}
        biding.checkBoxEURA.setOnCheckedChangeListener{_,_ ->updatePrograss()}
        biding.buttonApply.setOnClickListener{
            val type = if(biding.radioButtonAdult.isChecked) biding.radioButtonAdult.text
            else biding.radioButtonStudent.text
            val intent = Intent(this,CourseActivity::class.java)
            intent.putExtra("name", biding.editTextTextPersonName.text.toString())
            intent.putExtra("type", type)
            /*startActivity(intent)*/
            getResult.launch(intent)
        }
        Log.i("MainActivity", "OnCreate")
    }

/*

    override fun onStart() {
        super.onStart()
        myCycle.start()
        Log.i("MainActivity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "OnResum")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "OnPause")

    }


    override fun onStop() {
        super.onStop()
        myCycle.stop()
        Log.i("MainActivity", "onStop")

    }
*/



    fun updatePrograss(){
        var prograss = 0
        if (biding.editTextTextPersonName.text.isNotEmpty()) prograss ++
        if(biding.editTextPhone.text.isNotEmpty()) prograss ++
        if(biding.radioButtonAdult.isChecked || biding.radioButtonStudent.isChecked) prograss ++
        if(biding.checkBoxEURA.isChecked) prograss ++

        biding.progressBar.progress = prograss
        Log.d("progressBarMax값", "ProgressBar Max: ${biding.progressBar.max}")
        Log.d("true or false", "test : ${biding.progressBar.max == prograss}")
        biding.buttonApply.isEnabled = biding.progressBar.max == prograss
    }

}
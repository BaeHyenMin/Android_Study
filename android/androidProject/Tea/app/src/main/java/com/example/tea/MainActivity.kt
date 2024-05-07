package com.example.tea

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tea.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Timer
import java.util.prefs.Preferences
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel:MainViewModel by viewModels()
    private  val timer = Timer()
    private lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        preference = getSharedPreferences("food_record", MODE_PRIVATE)
        val lastFood = preference.getString("food", null)
        val lastTime = preference.getString("time", null)
/*        updateWidgets(lastFood, lastTime)
        binding.buttonSave.setOnClickListener { savedRecord() }*/

        viewModel.lastFood.value = lastFood
        viewModel.lastTime.value = lastTime

        viewModel.lastFood.observe(this) { binding.textViewLastFood.text = it }
        viewModel.lastTime.observe(this) { binding.textViewLastTime.text = it }
        viewModel.updateElapsedTime.observe(this){
            val elapsedTime = getElapsedTime(viewModel.lastTime.value)
            binding.textViewElapsedTime.text = getString(
                R.string.elapsed_time,
                elapsedTime.hours,
                elapsedTime.minutes,
                elapsedTime.seconds)
        }

        timer.schedule(1000, 1000) {
            viewModel.updateElapsedTime.postValue(true)
        }

        binding.buttonSave.setOnClickListener { saveRecord() }

    }

    private fun saveRecord(){

        val time = LocalDateTime.now().toString() // LocalDateTime to String
        val food = binding.editTextFood.text.toString()
        if(food.isNotEmpty()){
            preference.edit().run{
                putString("food", food)
                putString("time", time)
                apply()
            }
            viewModel.lastTime.value = time
            viewModel.lastFood.value = food
        }
    }

    private fun getElapsedTime(time:String?):ElapsedTime{
        if(time == null)
            return ElapsedTime()

        val now = LocalDateTime.now()
        val before = LocalDateTime.parse(time) // String to LocalDateTime

        val hours = ChronoUnit.HOURS.between(before, now)
        val minutes = ChronoUnit.MINUTES.between(before, now)%60
        val seconds = ChronoUnit.SECONDS.between(before, now)%60

        return ElapsedTime(hours, minutes, seconds)
    }


/*    private fun savedRecord(){
        val time = LocalDateTime.now().toString() // LocalDateTime to String
        val food = binding.editTextFood.text.toString()
        if(food.isNotEmpty()){
            preference.edit().run{
                putString("food", food)
                putString("time", time)
                apply()
            }
            updateWidgets(food, time)
        }

    }

    private fun getElapsedTime(before:String?):ElapsedTime{
        if(before == null)
            return ElapsedTime()

        val now = LocalDateTime.now()
        val before = LocalDateTime.parse(before) // String to LocalDateTime

        val hours = ChronoUnit.HOURS.between(before, now)
        val minutes = ChronoUnit.MINUTES.between(before, now)%60
        val seconds = ChronoUnit.SECONDS.between(before, now)%60

        return ElapsedTime(hours, minutes, seconds)

    }

    private fun updateWidgets(lastFood:String?, lastTime:String?){
        val elapsedTime = getElapsedTime(lastTime)
        binding.textViewLastFood.text = lastFood?:getString(R.string.no_food_saved)
        binding.textViewLastTime.text = lastTime?:getString(R.string.no_time_saved)
        binding.textViewElapsedTime.text = getString(R.string.elapsed_time, elapsedTime.hours, elapsedTime.minutes, elapsedTime.seconds)
    }*/
}
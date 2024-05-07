package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.game.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var count:Int = 0

    companion object {
        const val ROCK = 0
        const val SCISSORS = 1
        const val PAPER = 2

        const val WIN = 0
        const val DRAW = 1
        const val LOOSE = 2
        val RESULT = arrayOf("승","무","패")
        val SELECTION = arrayOf("가위","바위","보")
    }

    private val listener = View.OnClickListener {
/*        val str = when(Random.nextInt(3)){
            0 -> "승"
            1 -> "무"
            else -> "패"
        }
 */
        val user = when(it.id){
            R.id.buttonPaper -> PAPER
            R.id.buttonRock -> ROCK
            else -> SCISSORS
        }

        val app = Random.nextInt(3)

        var result = WIN

        if(user == app){
            result = DRAW
        } else {
            if((user == ROCK && app == PAPER) ||
                (user == PAPER && app == SCISSORS) ||
                (user == SCISSORS && app == ROCK)) result = LOOSE
        }


        val computer = when(app){
            PAPER -> "보"
            SCISSORS -> "가위"
            else -> "바위"

        }

        val resultStr = when(result){
            WIN -> "승"
            DRAW -> "무"
            else -> "패"
        }

        if(result == WIN){
            count ++
            binding.textViewWinConut.text = "$count"
        }
        binding.textViewResult.text = " 결과 : $resultStr \n 컴퓨터는 이거냈음 :  $computer"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
/*
        binding.buttonRock.setOnClickListener(this)
        binding.buttonScissers.setOnClickListener(this)
        binding.buttonPaper.setOnClickListener(this)
 */

        binding.buttonRock.setOnClickListener(listener)
        binding.buttonScissers.setOnClickListener(listener)
        binding.buttonPaper.setOnClickListener(listener)

    }






    override fun onClick(v: View?) {
        val computer = Random.nextInt(3)

        val result = when(v?.id){
            R.id.buttonRock -> if(computer == 1) "무승부" else if ( computer == 2) "이김" else "졌음"
            R.id.buttonScissers -> if(computer == 1) "졌음" else if ( computer == 2) "무승부" else "이김"
            else -> if(computer == 1) "이김" else if ( computer == 2) "졌음" else "무승부"
        }

        binding.textViewResult.text = "$result"
    }
}
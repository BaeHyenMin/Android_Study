package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.helloworld.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*private lateinit var binding : ActivityMainBinding*/

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val listener = View.OnClickListener {
        try {
            val n1 = binding.editTextNumber1.text.toString().toDouble()
            val n2 = binding.editTextNumber2.text.toString().toDouble()
            binding.textViewResult.text  = "${n1 - n2}"
        }catch (e:NumberFormatException){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


/*      //이게 방법 1
        //R의 약자는 res의 약자임ㅋㅋ
        //setContentView 함수를 써서 반환이 됬다는건 = 디자인 레이아웃을 메모리상에 잘 잡혔다(인플레이트 됬다) = 메모리상에 잡힌다는건 레이아웃을 객체로 잘 생성했다
        setContentView(R.layout.activity_main)


        //모든 레이아웃 파일을 탐색해서 textView라는 아이디를 찾아온다.
        //현재 내가 쓰는 레이아웃의 아이디를 못찾으면 실행할때 null을 리턴함
        //변수선언할때 타입지정
        val textView : TextView = findViewById(R.id.textView)

        //ㄹㅇ 왜 바뀜ㅋㅋ
        textView.text = "Hahahaaha"

        //제네릭으로 아이디 주는 방법 변수에는 타입지정 안해도됨 둘 중 아무거나 쓰면됨
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        textViewResult.text = "0.0"

 */



        /*
        //인플레이트가 뭐지?ㅋㅋ
        //메모리에 객체화 시키는거네 ㅋㅋ
        binding = ActivityMainBinding.inflate(layoutInflater)
        */


        //인플레이트 끝냈고 너는 화면만 띄우세요ㅋㅋㅋ
        //setContentView(R.layout.activity_main) 넣으면 도르마무임
        setContentView(binding.root)

        /*

        //이러면 내 레이아웃 파일 안에는 위젯 아이디만 들고 올 수 있음 ㅋㅋ
        binding.textView.text = "hello"

        */

        binding.buttonAdd.setOnClickListener(this)
        binding.buttonSub.setOnClickListener(this)
        binding.buttonMul.setOnClickListener(this)
        binding.buttonDiv.setOnClickListener(this)
/*
        binding.buttonSub.setOnClickListener(listener)
        //이르케 쓸 수도 있다~ ex) 팝업창이랑 취소버튼 누를때~
        binding.buttonMul.setOnClickListener(object : View.OnClickListener{
            try {
                val n1 = binding.editTextNumber1.text.toString().toDouble()
                val n2 = binding.editTextNumber2.text.toString().toDouble()
                binding.textViewResult.text  = "${n1 + n2}"
            }catch (e:NumberFormatException){

            }
        })


        binding.buttonMul.setOnClickListener(View.OnClickListener {
            try {
                val n1 = binding.editTextNumber1.text.toString().toDouble()
                val n2 = binding.editTextNumber2.text.toString().toDouble()
                binding.textViewResult.text  = "${n1 * n2}"
            }catch (e:NumberFormatException){

            }
        })
*/


    }

/*
    override fun onClick(v: View?) {
        try {
            val n1 = binding.editTextNumber1.text.toString().toDouble()
            val n2 = binding.editTextNumber2.text.toString().toDouble()
            binding.textViewResult.text  = "${n1 + n2}"
        }catch (e:NumberFormatException){

        }
    }
 */

    override fun onClick(v: View?) {
        try {
            val n1 = binding.editTextNumber1.text.toString().toDouble()
            val n2 = binding.editTextNumber2.text.toString().toDouble()
            val result = when(v?.id){
                R.id.buttonAdd -> n1 + n2
                R.id.buttonSub -> n1 - n2
                R.id.buttonMul -> n1 * n2
                else -> if(n2 != 0.0) n1/n2 else 0.0
            }

            binding.textViewResult.text = "$result"
        }catch (e:NumberFormatException){

        }
    }
}
class Test10(val id:Int){
    var a = 0
    var b = 0
}

fun main(){
    //let부터 좀 차근히 보자네..
    //null을 허용한 변수는 null 아닌지 계속확인해야되므로 let으로 감싸면
    //한 블록이 null이 아닌 상태가 되니깐 많이씀

    val list = listOf(1,2,3)
    //let 쓰면 이 문법
    val size = list.let{if(it.size > 5) it.size else 0}

    //with xxx.xxx 안하고 xxx.이 자동으로 제공
    val size2 = with(list){
        println("$size")
    }

    val size3 = list.run{size}


    //builder 느낌인가?
    val t = Test10(1).apply {
        a =1
        b=2
    }

    //let, run -> 람다식의 결과가 반환
    //apply, also -> 수신된 객체가 return
}
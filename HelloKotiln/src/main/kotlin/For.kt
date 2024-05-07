fun gugudan (n : Int){

    val dan = when(n){
        in 2..9-> n
        else -> 2
    }

    for (i in 1 until 10) {
        println("$dan x $i = ${dan * i}")
    }

}

fun main (){
    gugudan(readln().toInt())

    val dan = when(val n = readln().toInt()){
        in 2..9-> n
        else -> 2
    }

    for (i in 1 until 10) {
        println("$dan x $i = ${dan * i}")
    }
}
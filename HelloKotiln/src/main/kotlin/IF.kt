/*fun max(a: Int, b: Int): Int  {
    if(a>b) return a;
    else return b;
    /*자바문법임 ㅋㅋ*/
}*/

fun cknum(a: Int) : String = when(a){
    in 90..100 -> "A"
    in 80..90 -> "B"
    in 70..80 -> "C"
    in 60..70 -> "D"
    else -> "F"
}

fun main() = println("${cknum(readln().toInt())}")

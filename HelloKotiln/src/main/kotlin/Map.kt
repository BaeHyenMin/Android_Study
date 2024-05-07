fun main(){
    val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)
    map1.forEach { (t, v) -> print("$t,$v") }

    //코딩테스트에서 많이 나온데~
    //전화번호 찾기?
    for(key in map1.keys){
        println("${map1[key]}")
    }
}
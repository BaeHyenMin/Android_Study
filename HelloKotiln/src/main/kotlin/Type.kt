fun main(){
    val str: String? = null
    if(str != null){
        print(str.length)
    }

    //str null이냐? 하면 try catch 안해도 됨
    println(str?.length)
    //str null 이면 0이다
    print(str?.length?:0)

    //변수가 null을 허용을 할때 일시적으로 null을 허용을 함 일시적임 ㄹㅇ
    println(str!!.length)



}
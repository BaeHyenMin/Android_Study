class CompanionObject {
    var a : Int = 0
    companion object{

    }
}

interface Test4{
    fun test()
}

class TestImpl:Test4{
    override fun test() {
        TODO("Not yet implemented")

    }

}


interface Test5{
    fun message():String
    fun value():Int
}

class TestImpl2:Test5{
    override fun message(): String {
        return "히히"
    }

    override fun value(): Int {
        return 5
    }


}

fun interface  Test6{
    fun ddddd()
}

fun main(){
    val t2 : Test6 = Test6{"ddddd"}
    val t:Test5 = object : Test5{
        override fun message(): String{return "Hello"}
        override fun value(): Int { return 5; }
    }

    print("${t.message()} + ${t.value()}")
}




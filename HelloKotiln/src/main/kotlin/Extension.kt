class Extension {
}


class Box<T>(param:T){
    var value = param
}


class Box2<T>(){
    var value : T? = null
}


fun <T> hello(t:T): T{
    return t
}

fun Int.abs() = if (this < 0) -this else this

fun main(){
    val value = -3
    println(value.abs())
    println(25.abs())


    val b2 = Box(1)
    val b3 = Box("Hello")


    val b1 = Box2<Int>()


    val hello = hello<String>("Hello")


}
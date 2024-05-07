class Test
/*class Position(val x: Int, val y: Int){
    constructor() : this(2, 3)


}*/

open class Position(val x: Int, val y:Int){
    open val dimension = 2
    open fun printValue(){
        print("$dimension, $x, $y, ")
    }
}


class TPosition(val a: Int, val b: Int, val z:Int):Position(a,b){
    override val dimension = 3
    override fun printValue(){
        super.printValue()
        print(" $z ")
    }
}
fun main(){
    val p2 = TPosition(2,3,4)
    p2.printValue()
}


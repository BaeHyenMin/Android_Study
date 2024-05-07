class Student(){
    var id: Int = 0
        set(value){
            field = if(value < 0) 0 else value

        }
}


class Rectangle(var width: Int, var height: Int){
    val area : Int get() = width * height

}


class Test2{
    var count: Int = 0
        set(value) {
        field =  if(value < 0) 0 else value
    }

}



fun main(){
    val student : Student = Student()
    student.id = -1
    println(student.id)

    val r : Rectangle = Rectangle(3,4)
    println("${r.area}")
    r.width = 40
    println("${r.area}")

    val t2 = Test2()
    t2.count = -20

    println("${t2.count}")
}
fun main(){
    //0으로 초기화됨
    val arrayOfInt = Array(3){ 0 }
    //0,1,2로 초기화됨
    val arrayOfInt2 = Array(3){ it }

    print("$arrayOfInt , $arrayOfInt2" )

    //얜 타입이 String도 받아도됨
    val arr2:Array<Int> = arrayOf(1,2,3)
    //intArrayOf int만 받음
    val arr:IntArray = intArrayOf(1,2,3)

    //초기화 방법이 다름!

    //초기화는 다 0으로 초기화됨
    val arr3:IntArray = intArrayOf(3)

    //0으로 초기화됨
    val arrayOfInt4 = Array(3){ 0 }



    val arr4= arrayOf(1,2,3,4,5,6)
    //람다식으로 배열안에 있는값 하나씩 비교
    //한개라도 있으면 true
    val arny = arr.any { it == 1}

    //filter는 조건을 만족하는 배열에 항목만 따로 List로 만들어서 반환함
    //예 학생성적 80점이상 골라줘~
    val filter = arr.filter{it >  3}

    //찾으면 첫번째 항목만 return 그럼 5가 리턴 되겠네?ㅋㅋ
    //근데 못찾을 수 도 있으니 기본 타입이 ? 붙어서 null도 뜰수 있음 주의
    val find = arr.find { it > 3 }

    //배열 사이즈만큼 반복 중간에 안멈추는 애임 ㅋㅋ
    //그래서 중간에 멈출려면 find 쓰라넼ㅋ
    val foreach = arr.forEach { print(it) }
}
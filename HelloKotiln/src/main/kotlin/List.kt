fun  main(){
    //사이즈변경 x
    // 얘를 언제 쓰냐면 게시판 글 가져올때 씀
    val list1 = listOf(1,2,3)
    val list2 = listOf(1,2,3)

    //사이즈 변경 o
    //생각보다 안드로이드에선 잘 안쓴대~
    val list3 = mutableListOf(1)
    list3.add(2)

    //얜 순서까지 따짐! true
    println(list1 == list2)


    val set1 = setOf(1,2,3,3)
    val set2 = setOf(3,2,1)

    //set은 순서가 상관없어서 true임~
    //블루투스 설정 개발할때 스캔 때린 장비가 한번만 나와야할때~
    //블루투스는 스캔 한번 때려서 결과를 리턴한다고 해서 스캔이 멈추진 않죠~
    println(set1 == set2)



}
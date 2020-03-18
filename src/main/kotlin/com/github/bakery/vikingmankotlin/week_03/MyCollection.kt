package com.github.bakery.vikingmankotlin.week_03

class ListFactory{
    /* 동일한 컬렉션 인스턴스를 읽기전용 컬렉션과 변경 가능한 컬렉션이 동시 참조하여 읽기 전용 컬렉션이 항상 안전하지 않음을 보여라 */
    val source = mutableListOf(1,2, 3, 4)

    fun unModify () : List<Int> = source
    fun modify() : MutableList<Int> = source
}



fun main(){
    val f = ListFactory()

    val immutableList = f.unModify()
    val size = immutableList.size;
    f.modify().add(1)

    println(immutableList.size == size)
}
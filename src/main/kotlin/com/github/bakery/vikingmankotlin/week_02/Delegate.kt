package com.github.bakery.vikingmankotlin.week_02

// TODO: Delegate를 이용해 값을 넣을 때마다 그 값을 로깅해주는 List를 만들어봅시다.

class CountingSet<T> (
        val innertSet:MutableCollection<T> = HashSet<T>()
): MutableCollection<T> by innertSet {
    override fun add(element: T): Boolean {
        println(element)
        return innertSet.add(element)
    }
}


fun main(){
    val cset = CountingSet<Int>()
    cset.add(33)
}
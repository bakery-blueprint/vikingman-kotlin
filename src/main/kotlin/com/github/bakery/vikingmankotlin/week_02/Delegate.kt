package com.github.bakery.vikingmankotlin.week_02

// TODO: Delegate를 이용해 값을 넣을 때마다 그 값을 로깅해주는 MutableList를 만들어봅시다.

class LoggingList<T>(
        val innerSet : MutableCollection<T> = mutableListOf()
) : MutableCollection<T> by innerSet {
    override fun add(element: T): Boolean {
        println("add $element")
        return innerSet.add(element)
    }
}
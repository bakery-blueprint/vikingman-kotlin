package com.github.bakery.vikingmankotlin.week_04

interface Source<T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    // 9장의 내용을 바탕으로 해당 구문이 가능하도록 수정해봅시다
    val objects: Source<out Any> = strs
}

package com.github.bakery.vikingmankotlin.week_04


fun copy(from: Array<out Any>, to: Array<Any>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
 }

fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy(ints, any) // 해당 구문을 만족할 수 있는 copy 함수를 정의하고 간단한 테스트를 작성하세요
}
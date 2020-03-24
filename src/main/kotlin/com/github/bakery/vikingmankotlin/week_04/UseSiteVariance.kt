package com.github.bakery.vikingmankotlin.week_04


fun copy(source: Array<out Any>, destination: Array<Any>) {
    for (i in source.indices) {
        destination[i] = source[i]
    }
}

fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val anys = Array<Any>(3) { "" }
    copy(ints, anys) // 해당 구문을 만족할 수 있는 copy 함수를 정의하고 간단한 테스트를 작성하세요
    anys.forEach { println(it) }
}

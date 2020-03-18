package com.github.bakery.vikingmankotlin.week_03

/*  연산자 오버로딩을 통해 Water 클래스에 물 양에 대한 사칙연산을 구현하시오 */
operator fun Water.plus(other: Water): Int = this.amount + other.amount
operator fun Water.minus(other: Water): Int = this.amount - other.amount

fun main() {
    val water1 = Water("동해", 100)
    val water2 = Water("서해", 30)

    println(water1 + water2)
    println(water1 - water2)
}
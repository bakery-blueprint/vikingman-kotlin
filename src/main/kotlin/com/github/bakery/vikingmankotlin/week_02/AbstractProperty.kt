package com.github.bakery.vikingmankotlin.week_02

// TODO: Figure의 구현체를 두 가지 이상 만들고 테스트해봅시다.
interface Figure {
    // 정다각형인가?
    val isRegular: Boolean
}

class Rectangle (val x: Int, val y: Int): Figure {
    override val isRegular: Boolean
        get(){
            return when {
                x == y -> true
                else -> false
            }
        }

}

class Triangle(val line1: Int, val line2:Int, val line3:Int): Figure {
    override val isRegular: Boolean
        get(){
            return when {
                (line1 == line2) && (line2 == line3) && (line3 == line1) -> true
                else -> false
            }
        }

}

fun main (){

    val rectangle1 = Rectangle(3, 4)
    println(rectangle1.isRegular)

    val rectangle2 = Rectangle(3, 3)
    println(rectangle2.isRegular)

    val triangle = Triangle(3, 3, 3)
    println(triangle.isRegular)
}
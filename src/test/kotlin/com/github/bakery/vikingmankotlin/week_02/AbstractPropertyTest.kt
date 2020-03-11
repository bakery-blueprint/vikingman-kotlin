package com.github.bakery.vikingmankotlin.week_02

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AbstractPropertyTest {

    @Test
    fun 정삼각형확인(){
        val triangle = Triangle(3, 3, 3)
        println(triangle.isRegular)
    }

    @Test
    fun 정사각형확인(){
        val rectangle = Rectangle(3, 3)
        println(rectangle.isRegular)
    }

    @Test
    fun 정다각형아님(){
        val rectangle1 = Rectangle(3, 4)
        println(rectangle1.isRegular)
    }
}
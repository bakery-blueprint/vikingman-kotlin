package com.github.bakery.vikingmankotlin.week_02.answer

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ForToLambdaTest {
    @Test
    fun test() {
        val strings = listOf("타이어", "데모", "엄뉴", "카일리")

        val expectedResult = "타데엄카"
        assertEquals(expectedResult, forLoop(strings))
        assertEquals(expectedResult, lambda(strings))
        assertEquals(expectedResult, lambda2(strings))
    }
}

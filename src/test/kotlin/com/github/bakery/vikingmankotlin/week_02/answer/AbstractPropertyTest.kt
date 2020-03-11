package com.github.bakery.vikingmankotlin.week_02.answer

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class AbstractPropertyTest {
    @Test
    fun figureTest() {
        val triangle = Triangle(3, 2, 1)
        val regularTriangle = Triangle(3, 3, 3)
        val rectangle = Rectangle(5, 3)
        val regularRectangle = Rectangle(5, 5)

        assertFalse(triangle.isRegular)
        assertTrue(regularTriangle.isRegular)
        assertFalse(rectangle.isRegular)
        assertTrue(regularRectangle.isRegular)
    }
}

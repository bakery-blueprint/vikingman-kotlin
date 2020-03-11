package com.github.bakery.vikingmankotlin.week_02.answer

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ApplyTest {
    @Test
    fun test() {
        val user = User.newBasicUser("", 27)
        val errors = user.validate()

        assertEquals(1, errors.getFieldErrorCount("name"))
    }
}

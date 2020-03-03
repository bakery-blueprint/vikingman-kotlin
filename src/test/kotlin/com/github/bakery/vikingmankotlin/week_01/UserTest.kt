package com.github.bakery.vikingmankotlin.week_01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class UserTest {

    @Test
    fun testExceptionWhenNameIsEmpty() {
        val user = User("", 27)
        val errors = user.validate()

        assertEquals(1, errors.getFieldErrorCount("name"))
    }

    @Test
    fun testExceptionWhenAgeIsLessThanZero() {
        val user = User("eomnew", 0)
        val errors = user.validate()

        assertEquals(1, errors.getFieldErrorCount("age"))
    }

    @Test
    fun testExceptionWhenUserIsValid() {
        val user = User("eomnew", 27)
        val errors = user.validate()

        assertThat(errors.hasErrors()).isEqualTo(false)
    }
}
package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class UserTest {

    @Test
    fun validateNameEmptyException() {
        val user = User("", 3)
        val error = user.validate()
        assertFailsWith<java.lang.Exception>{
            if(error.hasFieldErrors("name"))
                throw Exception(error.getFieldError("name").toString())
        }

    }

    @Test
    fun validateAgeLessThenZeroException() {
        val user = User("demo", -1)
        val error = user.validate()
        assertFailsWith<java.lang.Exception>{
            if(error.hasFieldErrors("age"))
                throw Exception(error.getFieldError("age").toString())
        }
    }

    @Test
    fun validate() {
        val user = User("demo", 30)
        val error = user.validate()

        if(error.hasErrors())
            throw Exception("fail")
    }

    @Test
    fun getName() {
        val user = User("demo", 30)
        assertEquals("demo", user.name)
    }

    @Test
    fun getAge() {
        val user = User("demo", 30)
        assertEquals(30, user.age)
    }
}
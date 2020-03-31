package com.github.bakery.vikingmankotlin.week_02

import java.lang.IllegalArgumentException

interface User {
    val name: String
    val age: Int
    companion object {
        fun getInstance(type : String, name: String, age: Int) : User {
            return when(type) {
                "basic" -> BasicUser(name, age)
                "email" -> EmailUser(name, age)
                else -> throw IllegalArgumentException()
            }
        }
    }
}

class BasicUser(override val name: String, override val age: Int) : User

class EmailUser(val email: String, override val age: Int) : User {
    override val name: String
        get() = email.substringBefore('@')
}



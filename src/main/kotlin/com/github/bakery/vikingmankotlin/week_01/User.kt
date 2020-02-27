package com.github.bakery.vikingmankotlin.week_01

import org.springframework.validation.BindException
import org.springframework.validation.Errors

/**
 *
 * 1. User validate를 테스트 코드로 검증해보자.
 * 2. validate를 확장함수로 변경해서 처리해보자.
 *
 */
class User(val name : String, val age: Int)

fun User.validate(): Errors  {
    val errors = BindException(this, User::class.qualifiedName.orEmpty())
    if (name.isEmpty()) {
        errors.rejectValue("name", "", "name is empty")
    }

    if (age <= 0) {
        errors.rejectValue("age", "", "age is less than 0")
    }
    return errors
}

fun main(args : Array<String>) {
    val user = User("demo", 30)
    val errors = user.validate()
    println(errors)
}
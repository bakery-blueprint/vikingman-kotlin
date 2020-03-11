package com.github.bakery.vikingmankotlin.week_02.answer

import com.github.bakery.vikingmankotlin.week_02.User
import org.springframework.validation.BindException
import org.springframework.validation.Errors

fun User.validate(): Errors {
    return BindException(this, User::class.qualifiedName.orEmpty()).apply {
        if (name.isEmpty()) {
            rejectValue("name", "", "name is empty")
        }

        if (age <= 0) {
            rejectValue("age", "", "age is less than 0")
        }
    }
}

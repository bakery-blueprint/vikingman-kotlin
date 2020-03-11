package com.github.bakery.vikingmankotlin.week_02

import org.springframework.validation.BindException
import org.springframework.validation.Errors

// TODO: apply {} 를 사용하도록 변경 해봅시다.
fun User.validate() = BindException(this, User::class.qualifiedName.orEmpty()).apply {
    if (name.isEmpty()) {
        rejectValue("name", "", "name is empty")
    }

    if (age <= 0) {
        rejectValue("age", "", "age is less than 0")
    }
}

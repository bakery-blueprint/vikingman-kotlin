package com.github.bakery.vikingmankotlin.week_02

import org.springframework.validation.BindException
import org.springframework.validation.Errors

// TODO: apply {} 를 사용하도록 변경 해봅시다.
//fun User.validate(): Errors {
//    val errors = BindException(this, User::class.qualifiedName.orEmpty())
//
//    if (name.isEmpty()) {
//        errors.rejectValue("name", "", "name is empty")
//    }
//
//    if (age <= 0) {
//        errors.rejectValue("age", "", "age is less than 0")
//    }
//
//    return errors;
//}


fun User.validate() :Errors {
   return BindException(this, User::class.qualifiedName.orEmpty())
           .apply {
               if (name.isEmpty()) {
                   this.rejectValue("name", "", "name is empty")
               }
               if (age <= 0) {
                   this.rejectValue("age", "", "age is less than 0")
               }
           }
}


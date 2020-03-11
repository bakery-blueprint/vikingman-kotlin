package com.github.bakery.vikingmankotlin.week_02.answer

import com.github.bakery.vikingmankotlin.week_02.BasicUser
import com.github.bakery.vikingmankotlin.week_02.EmailUser

interface User {
    val nickname: String

    companion object {
        fun newBasicUser(nickname: String, age: Int) = BasicUser(nickname, age)
        fun newEmailUser(email: String, age: Int) = EmailUser(email, age)
    }
}

package com.github.bakery.vikingmankotlin.week_02

// TODO: User의 companion object를 선언해서 factory 메서드를 만들고 테스트해봅시다.
interface User {
    val name: String
    val age: Int
    companion object {
        fun newBasicUser(name: String, age: Int) {
            BasicUser(name, age)
        }

        fun newEmailUser(email: String, age: Int) {
            EmailUser(email, age)
        }

    }
}

class BasicUser(override val name: String, override val age: Int) : User

class EmailUser(val email: String, override val age: Int) : User {
    override val name: String
        get() = email.substringBefore('@')
}


fun main(){
    val basicUser = User.newBasicUser("demo", 20)
    val emailUser = User.newEmailUser("demo.lim@aa.com", 20)

    println(basicUser)
    println(emailUser)
}
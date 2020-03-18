package com.github.bakery.vikingmankotlin.week_03

import kotlin.reflect.KProperty

data class Person(val name: String, val email: String)

val database: MutableMap<String, MutableMap<String, String>> = mutableMapOf(
        "1" to mutableMapOf("name" to "김", "email" to "김@a.com"),
        "2" to mutableMapOf("name" to "엄", "email" to "엄@b.com"),
        "3" to mutableMapOf("name" to "임", "email" to "임@c.com"),
        "4" to mutableMapOf("name" to "홍", "email" to "홍@d.com"))



class DatabaseDelegate(val id: String) {

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return findColumnByUserId(prop.name, this.id)
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        setColumnByUserId(prop.name, this.id, value)
    }

    private fun findColumnByUserId(column: String, userId: String): String {
        return database[userId]?.get(column) ?: "$column is empty"
    }

    private fun setColumnByUserId(column: String, userId: String, value:String) {
        database[userId]?.put(column, value)
    }

}

class DatabaseUser(userId: String) {
    var name: String by DatabaseDelegate(userId)
    var email: String by DatabaseDelegate(userId)

    override fun toString(): String {
        return "name : $name, email : $email"
    }
}

fun main(){

    val databaseUser = DatabaseUser("1")
    println(databaseUser)
    databaseUser.email = "434@34.com"
    println(databaseUser)

}

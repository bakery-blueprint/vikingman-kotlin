package com.github.bakery.vikingmankotlin.week_03

import kotlin.reflect.KProperty

data class Person(val name: String, val email: String)

val database: MutableMap<String, MutableMap<String, String>> = mutableMapOf(
        "1" to mutableMapOf("name" to "김", "email" to "김@a.com"),
        "2" to mutableMapOf("name" to "엄", "email" to "엄@b.com"),
        "3" to mutableMapOf("name" to "임", "email" to "임@c.com"),
        "4" to mutableMapOf("name" to "홍", "email" to "홍@d.com"))



class Databaseㅇ(val id: String) {

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return ""
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
    }

}

class DatabaseUser(userId: String) {
//    var name: String by DatabaseDelegate(userId)
//    var email: String by DatabaseDelegate(userId)
}

fun main(){

    /* 데이터베이스에서 user id에 맞는 데이터를 가지고 오는 Delegate 를 완성하시오 */
}

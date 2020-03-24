package com.github.bakery.vikingmankotlin.week_04

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.bakery.vikingmankotlin.week_01.User
import kotlin.test.assertEquals

inline fun <reified T> String.toKotlinObject(): T {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(this, T::class.java)
}

fun main() {
    val json = """{"name":"엄뉴", "age":27}"""
    println(json.toKotlinObject<User>().age == 27)
    println(json.toKotlinObject<User>().name == "엄뉴")


    // 위의 json을 User로 받아서 이름과 나이를 출력해보고 간단한 테스트를 작성해보세요!
}
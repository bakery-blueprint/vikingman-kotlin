package com.github.bakery.vikingmankotlin.week_04

data class Person(val name: String, val salary: Int)

fun lookForEomnew(people: List<Person>) {
    people.forEach {
        if (it.name == "엄뉴") {
            println("발견!!")
            return@forEach
        }
    }
    println("여기도 출력됐으면 좋겠어요!!")
}

// label 지정
fun lookForEomnew2(people: List<Person>) {
    people.forEach label@ {
        if (it.name == "엄뉴") {
            println("발견!!")
            return@label
        }
    }
    println("여기도 출력됐으면 좋겠어요!!")
}

// 무명함수
fun lookForEomnew3(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "엄뉴") {
            println("발견!!")
            return
        }
    })
    println("여기도 출력됐으면 좋겠어요!!")
}


fun main() {
    val people =
            listOf(Person("데모", 100000000),
            Person("엄뉴", 100000000),
            Person("카일리", 100000000),
            Person("타이어", 100000000))

    lookForEomnew(people)
}
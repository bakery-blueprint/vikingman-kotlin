package com.github.bakery.vikingmankotlin.week_04

data class Person(val name: String, val salary: Int)

fun lookForEomnew(people: List<Person>) {
    people.forEach{
        if (it.name == "엄뉴") {
            println("발견!!")
            return@forEach
        }
    }
    println("여기도 출력됐으면 좋겠어요!!") // 해당 구문이 출력될 수 있도록 변경해보세요! (2가지 이상의 방법)
}



fun main() {
    val people =
            listOf(Person("데모", 100000000),
            Person("엄뉴", 100000000),
            Person("카일리", 100000000),
            Person("타이어", 100000000))

    lookForEomnew(people)
}


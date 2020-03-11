package com.github.bakery.vikingmankotlin.week_02

// TODO: 람다를 사용하도록 변경해봅시다.
fun forloop(targets: Iterable<String>): String{
    var firstChars = ""

    targets.forEach {
        target: String ->
        target.let { firstChars += target[0] }
    }

    return firstChars
}


fun main(){
    println(forloop(listOf("1", "2")))
}
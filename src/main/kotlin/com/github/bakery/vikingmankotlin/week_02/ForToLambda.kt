package com.github.bakery.vikingmankotlin.week_02


fun forloop(targets: Iterable<String>):String = targets
        .asSequence()
        .filter { s: String -> s.isNotEmpty()}
        .map { s: String -> s.first() }.joinToString {  ","}

// TODO: 람다를 사용하도록 변경해봅시다.
fun forLoop(targets: Iterable<String>): String {
    var firstChars = ""
    for (target in targets) {
        if (target.isNotEmpty()) {
            firstChars += target[0]
        }
    }
    return firstChars
}


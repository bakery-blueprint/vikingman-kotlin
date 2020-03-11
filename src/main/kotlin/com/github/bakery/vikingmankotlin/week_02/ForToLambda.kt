package com.github.bakery.vikingmankotlin.week_02

// TODO: 람다를 사용하도록 변경해봅시다.
fun forloop(targets: Iterable<String>) {
    var firstChars = ""
    targets.filter { it.isNotEmpty() }
            .map { firstChars += it[0]}
}

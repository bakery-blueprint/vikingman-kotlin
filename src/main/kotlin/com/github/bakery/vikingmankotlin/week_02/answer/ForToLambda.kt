package com.github.bakery.vikingmankotlin.week_02.answer

fun forLoop(targets: Iterable<String>): String {
    var firstChars = ""
    for (target in targets) {
        if (target.isNotEmpty()) {
            firstChars += target[0]
        }
    }
    return firstChars
}

fun lambda(targets: Iterable<String>): String {
    var firstChars = ""
    targets.asSequence().filter { it.isNotEmpty() }.forEach { firstChars += it[0] }
    return firstChars
}

fun lambda2(targets: Iterable<String>): String {
    return targets.asSequence().filter { it.isNotEmpty() }.map { it[0] }.joinToString("")
}

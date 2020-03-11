package com.github.bakery.vikingmankotlin.week_02

fun forloop(targets: Iterable<String>):String = targets
        .asSequence()
        .filter { s: String -> s.isNotEmpty()}
        .map { s: String -> s.first() }.joinToString {  ","}
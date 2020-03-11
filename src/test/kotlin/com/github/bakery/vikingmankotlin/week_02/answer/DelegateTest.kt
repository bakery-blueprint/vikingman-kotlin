package com.github.bakery.vikingmankotlin.week_02.answer

import org.junit.jupiter.api.Test

internal class DelegateTest {
    @Test
    fun test() {
        val loggingMutableList = LoggingMutableList(mutableListOf(1, 2, 3))

        loggingMutableList.add(4)
        loggingMutableList.addAll(listOf(5, 6, 7))
    }
}

package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class BakeryTest {
    /**
     * When을 사용해
     *
     * 도넛일 때 던킨
     * 크로와상일 떄 파리바게트를
     * 리턴하고 검증하세요.
     */
    @Test
    fun verifyWhen() {
        fun verify(bakery: Bakery) = when(bakery) {
            Bakery.DOUGHNUT -> "던킨~!"
            Bakery.CROISSANT -> "파리바게트~!"
        }

        println(verify(Bakery.DOUGHNUT))
        println(verify(Bakery.CROISSANT))

    }
    /**
     * if를 when으로 변경하세요.
     */
    @Test
    fun replaceIfToB() {
        val data = "abc"

        when{
            data.equals("abc") -> {
                println("equals")
                "equals"
            }
            (data.length == 4) -> {
                println("4!!")
                "4!!"
            }
            else -> IllegalArgumentException("Unknown")
        }
    }

}
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

    }
    /**
     * if를 when으로 변경하세요.
     */
    @Test
    fun replaceIfToB() {
        val data = "abc"
        if ("abc".equals(data)) {
            println("equals")
        }  else if (data.length == 4) {
            println("4!!")
        } else {
            throw IllegalArgumentException("Unknown")
        }
    }

}
package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

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
        fun validate(bakery: Bakery) = when (bakery) {
            Bakery.DOUGHNUT -> "던킨"
            Bakery.CROISSANT -> "크로와상"
        }

        assertEquals("던킨", validate(Bakery.DOUGHNUT))
        assertEquals("크로와상", validate(Bakery.CROISSANT))
    }
    /**
     * if를 when으로 변경하세요.
     */
    @Test
    fun replaceIfToB() {
        val data = "abc"

        // 인자 없는 when
        when {
            ("abc".equals(data)) -> println("equals")
            (data.length == 4) -> println("4!!")
            else -> throw IllegalArgumentException("Unknown")
        }
    }

}
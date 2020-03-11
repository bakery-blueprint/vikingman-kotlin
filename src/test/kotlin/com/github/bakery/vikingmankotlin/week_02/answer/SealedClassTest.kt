package com.github.bakery.vikingmankotlin.week_02.answer

import com.github.bakery.vikingmankotlin.week_02.Num
import com.github.bakery.vikingmankotlin.week_02.Sum
import com.github.bakery.vikingmankotlin.week_02.eval
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SealedClassTest {
    @Test
    fun exprTest() {
        assertThat(eval(Sum(Sum(Num(1), Num(2)), Num(4)))).isEqualTo(7)
    }
}

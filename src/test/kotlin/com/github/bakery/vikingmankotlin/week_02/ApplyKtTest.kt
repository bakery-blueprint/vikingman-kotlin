package com.github.bakery.vikingmankotlin.week_02

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ApplyKtTest {
    @Test
    fun test() {
        // given
        val user = BasicUser("123", -1)

        // when
        val result = user.validate()

        // then
        Assertions.assertThat(result.allErrors.size).isEqualTo(1);
    }
}
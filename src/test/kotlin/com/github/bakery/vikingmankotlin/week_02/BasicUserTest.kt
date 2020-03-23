package com.github.bakery.vikingmankotlin.week_02

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class BasicUserTest() {

    @Test
    fun getInstance() {
        // given, when
        val user = User.getInstance("basic", "hello", 1)

        // then
        Assertions.assertThat(user).isInstanceOf(BasicUser::class.java)
    }
}
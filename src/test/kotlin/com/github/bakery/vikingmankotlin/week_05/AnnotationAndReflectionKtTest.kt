package com.github.bakery.vikingmankotlin.week_05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnnotationAndReflectionKtTest {
    @Test
    fun getHash() {
        // given
        val person = PersonEntity("hello", 2)

        // when
        val result = person.getHash()

        // then
        assertThat(result).isEqualTo("0b0439e4372b2d91f3c9dcb6404d008afc9fb22c7490dee3c08170f3858822a2");
    }

    @Test
    fun declaredMemberPropertyTest() {
        // given
        val person = object:HashAware {
            val name = ""
        }

        // when
        val property = person::class.declaredMemberProperty("name")


        // then
        assertThat(property?.name).isEqualTo("name")
    }
}
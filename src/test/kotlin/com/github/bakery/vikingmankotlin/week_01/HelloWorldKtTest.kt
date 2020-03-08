package com.github.bakery.vikingmankotlin.week_01

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class HelloWorldKtTest {
    /**
     * hello 를 검증하세요..!!
     */
    @Test
    fun hello() {
        // given
        val expected = "hello";
        val helloWorld = HelloWorld()

        // when
        val result = helloWorld.hello()

        // then
        assertThat(result).isEqualTo(expected);
    }

    /**
     *  문자열 템플릿을 사용해 hello를 출력하세요.
     */
    @Test
    fun printHello() {
        // given
        val hello = "hello";

        println("${hello}")
        // no assert
        println("$hello")
    }

    /**
     * CustomAccessor에 커스텀 접근자를 생성해서 검증하세요.
     */
    @Test
    fun get() {
        // given
        val data = "hello"
        val customAccessor = CustomAccessor(data)

        // when
        val result = customAccessor.last

        // then
        assertThat(result).isEqualTo(data.get(data.lastIndex))
    }

}

class CustomAccessor(var data: String) {
    var last: Char = ' '
        get() {
            return data[data.lastIndex]
        }
}
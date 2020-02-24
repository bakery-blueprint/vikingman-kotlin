package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class HelloWorldKtTest {
    /**
     * hello 를 검증하세요..!!
     */
    @Test
    fun hello() {
        // given
        val expected = "hello"

        // when
        val actual = HelloWorld().hello()

        // then
        assertEquals(expected, actual)
    }

    /**
     *  문자열 템플릿을 사용해 hello를 출력하세요.
     */
    @Test
    fun printHello() {
        // given
        val hello = "hello";


        // no assert
        println("$hello")
    }

    /**
     * CustomAccessor에 커스텀 접근자를 생성해서 검증하세요.
     */
    @Test
    fun get() {
        val hello = "hello"
        val customAccessor = CustomAccessor(hello)

        assert(customAccessor.isHello)
    }

}

class CustomAccessor(var data: String) {
    val isHello: Boolean
    get() {
        return "hello" == data
    }
}
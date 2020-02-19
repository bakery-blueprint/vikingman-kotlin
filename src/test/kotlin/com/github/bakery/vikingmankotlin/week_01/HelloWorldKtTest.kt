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
        val helloWorld = HelloWorld()
        val expect = "hello"

        // when
        val actual = helloWorld.hello()

        // then
        assertEquals(expect, actual)
    }

    /**
     *  문자열 템플릿을 사용해 hello를 출력하세요.
     */
    @Test
    fun printHello() {
        // given
        val hello = "hello"

        println("$hello")

        // no assert
    }

    /**
     * CustomAccessor에 커스텀 접근자를 생성해서 검증하세요.
     */
    @Test
    fun get() {
        // given
        val expect = "hello"
        var customAccessor: CustomAccessor = CustomAccessor(expect)

        // when
        val actual = customAccessor.data

        //
        assertEquals(expect + "!", actual)
    }

}


class CustomAccessor(data: String) {
    var data: String = data
        get() = "$field!"
}


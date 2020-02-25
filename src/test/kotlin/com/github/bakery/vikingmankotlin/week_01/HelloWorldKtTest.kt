package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


internal class HelloWorldKtTest {
    /**
     * hello 를 검증하세요..!!
     */
    @Test
    fun hello() {
        // given
        val helloWorld = HelloWorld()

        // when
        val result = helloWorld.hello()

        // then
        assertEquals("hello", result)
    }

    /**
     *  문자열 템플릿을 사용해 hello를 출력하세요.
     */
    @Test
    fun printHello() {
        // given
        val hello = "hello";

        print("Tire $hello~")
        // no assert
    }

    /**
     * CustomAccessor에 커스텀 접근자를 생성해서 검증하세요.
     */
    @Test
    fun get() {
        val target = CustomAccessor("hello")
        
        assertTrue(target.isHello)
    }

}

class CustomAccessor(var data: String) {
    val isHello: Boolean
        get() = "hello" == data
}

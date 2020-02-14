package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test


internal class HelloWorldKtTest {
    /**
     * hello 를 검증하세요..!!
     */
    @Test
    fun hello() {
        // given

        // when

        // then
    }

    /**
     *  문자열 템플릿을 사용해 hello를 출력하세요.
     */
    @Test
    fun printHello() {
        // given
        val hello = "hello";


        // no assert
    }

    /**
     * CustomAccessor에 커스텀 접근자를 생성해서 검증하세요.
     */
    @Test
    fun get() {

    }

}

class CustomAccessor(var data: String) {

}
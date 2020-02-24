package com.github.bakery.vikingmankotlin.week_01

import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class BaseServiceTest {
    class WrapperException(e : Exception) : RuntimeException()

    /**
     * catch 해서 테스트 코드를 완성하세요..!!
     */
    @Test
    fun catch() {
        val service = BaseService()
        fun validateCatch(service: BaseService) {
            try {
                service.service()
            } catch (e: IllegalStateException) {
                throw WrapperException(e)
            }
        }

        assertFailsWith<WrapperException> { validateCatch(service) }
    }
}
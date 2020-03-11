package com.github.bakery.vikingmankotlin.week_02.answer

import com.github.bakery.vikingmankotlin.week_02.BasicUser
import com.github.bakery.vikingmankotlin.week_02.EmailUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class CompanionObjectTest {
    @Test
    fun userTest() {
        val input = "kylie@mail.com"
        val basicUser = User.newBasicUser(input, 5)
        val emailUser = User.newEmailUser(input, 5)

        assertTrue(basicUser is BasicUser)
        assertThat(basicUser.name).isEqualTo(input)
        assertTrue(emailUser is EmailUser)
        assertThat(emailUser.name).isEqualTo(input.substringBefore("@"))
    }
}

package com.github.bakery.vikingmankotlin.week_04

import com.github.bakery.vikingmankotlin.week_01.Bakery

/* week_01의 Bakery에 대하여 도넛은 10% 할인, 크로와상은 15% 할인한다고 할 때, 지불금액이 얼마인지 계산하는 고차함수를 정의하시오 */

class ShoppingCart(val bakery: Bakery, val itemCount: Int, val itemCost: Int)

// 함수 정의
// fun ...() ...

fun main() {
    val cart = ShoppingCart(Bakery.DOUGHNUT, 3, 1000)
}
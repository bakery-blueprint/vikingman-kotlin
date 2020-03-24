package com.github.bakery.vikingmankotlin.week_04

import com.github.bakery.vikingmankotlin.week_01.Bakery

/* week_01의 Bakery에 대하여 도넛은 10% 할인, 크로와상은 15% 할인한다고 할 때, 지불금액이 얼마인지 계산하는 고차함수를 정의하시오 */

class ShoppingCart(val bakery: Bakery, val itemCount: Int, val itemCost: Int) {
    fun getTotalPrice(discountFun: (Bakery) -> Int) = itemCount * itemCost * ((100 - discountFun(bakery)) / 100.0)
}

// 함수 정의
fun discountPrice(): (ShoppingCart) -> Double {
    return { cart ->
        val discountPercentage = when (cart.bakery) {
            Bakery.DOUGHNUT -> 10
            Bakery.CROISSANT -> 15
        }
        (cart.itemCost * cart.itemCount * ((100 - discountPercentage) / 100.0))
    }
}

fun getDiscountPercent(): (Bakery) -> Int = { bakery ->
    when (bakery) {
        Bakery.DOUGHNUT -> 10
        Bakery.CROISSANT -> 15
    }
}


fun main() {
    val cart = ShoppingCart(Bakery.DOUGHNUT, 3, 1000)
    println(cart.getTotalPrice(getDiscountPercent()))
}

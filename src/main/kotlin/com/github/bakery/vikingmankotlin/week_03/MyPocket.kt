package com.github.bakery.vikingmankotlin.week_03

class MyPocket{
    private lateinit var water: Water
    fun checkMyWaterAmount(): Int = water.amount
    /* 외부에서 물을 주입받아 내 물 양이 얼마나 남았는지 체크하는 함수를 만드시오 */
    fun setWater(water: Water) {
        this.water = water
    }
}

fun main(){
    val pocket = MyPocket()
    pocket.setWater(Water("where", 100))
    println(pocket.checkMyWaterAmount())
}

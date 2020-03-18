package com.github.bakery.vikingmankotlin.week_03

class MyPocket{
    private lateinit var water: Water

    fun checkMyWaterAmount(): Int = water.amount
    fun setWater(myWater: Water) {
        water = myWater
    }
    /* 외부에서 물을 주입받아 내 물 양이 얼마나 남았는지 체크하는 함수를 만드시오 */
}

fun main(){

    val demo = MyPocket()
    val water = Water("제주", 400)
    demo.setWater(water)
    println(demo.checkMyWaterAmount())

}
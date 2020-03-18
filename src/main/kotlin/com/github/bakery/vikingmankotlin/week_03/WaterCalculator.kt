package com.github.bakery.vikingmankotlin.week_03

/*  연산자 오버로딩을 통해 Water 클래스에 물 양에 대한 사칙연산을 구현하시오 */

fun main(){
    val waterFromJeju500 = Water("제주도", 500)
    val waterFromJeju200 = Water("제주도", 200)
    val waterFromFrance = Water("프랑스", 400)

//    val totalWater = waterFromFrance + waterFromJeju500
    val totalWater = waterFromJeju200 + waterFromJeju500
    println(totalWater.amount)


}
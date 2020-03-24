package com.github.bakery.vikingmankotlin.week_04


 fun <T> copy(source : Array<out T>, target: Array<T>) {

     for(i in source.indices){
         target.set(i, source[i])
     }
 }

fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy(ints, any) // 해당 구문을 만족할 수 있는 copy 함수를 정의하고 간단한 테스트를 작성하세요

    for(element in any){
        println(element)
    }
}
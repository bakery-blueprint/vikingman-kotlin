package com.github.bakery.vikingmankotlin.week_08.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield


fun yieldThreeTimes() {
/*    log("1")
    delay(1000L)
    yield()
    log("2")
    delay(1000L)
    yield()
    log("3")
    delay(1000L)
    yield()
    log("4")*/
}

suspend fun yieldThreeTimesWithSuspend() {
    log("1")
    delay(1000L)
    yield()
    log("2")
    delay(1000L)
    yield()
    log("3")
    delay(1000L)
    yield()
    log("4")
}

fun suspendExample() {
    GlobalScope.launch { yieldThreeTimesWithSuspend() }    // launch 안의 호출코드가 복잡하다면 별도의 suspend 함수로!
}
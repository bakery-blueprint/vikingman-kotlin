package com.github.bakery.vikingmankotlin.week_08.example

import kotlinx.coroutines.*

fun yieldExample() {
    runBlocking {

        launch {
            log("1")
            yield()
            log("3")
            yield()                 // 아직 delay 상태이기 때문에, 다시 제어가 돌아옴!
            log("5")
        }

        log("after first launch")

        launch {
            log("2")
            delay(1000L)    // delay가 끝날 때까지 다른 코루틴에게 실행을 양보
            log("4")
            delay(1000L)
            log("6")
        }

        log("after second launch")
    }

    log("after runBlocking")
}

fun main() {
    log("main() started.")
    yieldExample()
    log("yieldExample() executed")
    log("main() terminated")
}
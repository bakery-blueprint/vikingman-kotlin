package week_08.example

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sumAll() {
    runBlocking {
        val d1 = async { delay(1000L); "a" }
        log("after async(d1)")
        val d2 = async { delay(2000L); "b" }
        log("after async(d2)")
        val d3 = async { delay(3000L); "c" }
        log("after async(d3)")

        log("a+b+c = ${d1.await() + d2.await() + d3.await()}")      // 여기까지 찍히는데 6초가 걸릴까?
        log("after await all & add")
    }
}

fun main() {
    sumAll()
}
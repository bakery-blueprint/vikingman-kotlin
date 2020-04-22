package week_08

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("mm:ss", Locale.KOREA)

fun timer(timerMillis: Long, timerStartTime: Long) {
    runBlocking {
        launch {
            while(isActive) {
                val nowRemainMillis = System.currentTimeMillis() - timerStartTime
                val timeRemainMillis = timerMillis - nowRemainMillis
                if (timeRemainMillis >= 0) {
                    println("now ${simpleDateFormat.format(timeRemainMillis)}")
                } else {
                    break
                }
                delay(1000L)
            }
        }
    }
}

fun main() {
    // 현재 시간으로부터 timerMillis ms 후에 아래의 println이 출력되는 timer 함수를 구현하세요
    timer(10000, System.currentTimeMillis())
    println("finish!!!")
}


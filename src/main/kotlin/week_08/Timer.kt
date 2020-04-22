package week_08

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("mm:ss", Locale.KOREA)

const val unit = 1000L
fun timer(timerMillis: Long, timerStartTime: Long) {
    runBlocking {
        var leftMillis = timerMillis
        launch {
            while (leftMillis > 0) {
                println("now ${simpleDateFormat.format(Date(leftMillis))}")
                leftMillis -= unit
                delay(unit)
            }
        }
    }
}

fun main() {
    // 현재 시간으로부터 timerMillis ms 후에 아래의 println이 출력되는 timer 함수를 구현하세요
    timer(10000, System.currentTimeMillis())
    println("finish!!!")
}

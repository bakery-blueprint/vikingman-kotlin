package week_08

import java.text.SimpleDateFormat
import java.util.*

val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("mm:ss", Locale.KOREA)



fun timer(timerMillis: Long, timerStartTime: Long) {

    val endTime = (timerMillis/1000).toInt()
    for(i in 1 .. (endTime+1)){
        GlobalScope.launch {
            delay(1000 * (endTime+1-i))
            println("now ${simpleDateFormat.format(i)}")
        }
    }



}

fun main() {
    // 현재 시간으로부터 timerMillis ms 후에 아래의 println이 출력되는 timer 함수를 구현하세요
    timer(10000, System.currentTimeMillis())
    println("finish!!!")
}
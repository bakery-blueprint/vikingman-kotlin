package week_08.example

import kotlinx.coroutines.*

fun runBlockingExample() {
    runBlocking {   // CoroutineScope의 확장함수가 아닌 일반 함수이므로 객체없이 바로 사용가능
        launch {
            log("GlobalScope.launch started.")
        }
    }
}

fun main() {
    log("main() started.")
    runBlockingExample()
    log("runBlockingExample() executed")
    log("main() terminated")
}
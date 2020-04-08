package com.github.bakery.vikingmankotlin.week_06.sample

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate

/**
 *  type-safe builder(수신객체지정 람다)
 *  재사용 빌더
 *  invoke(클래스 인스턴스를 함수처럼)
 *  중위호출 연쇄
 *  원시타입 확장함수
 *  멤버 확장함수
 */

class Http(private val restTemplate: RestTemplate = RestTemplate()) {
    private val url = URL()

    operator fun invoke(block: URL.() -> Unit) = this.apply { url.block() }

    fun post(responseType: Class<out Any>, block: POST.() -> Unit) = restTemplate.postForEntity(
            "$SCHEMA://$url",
            //TODO: 아래 더미 HttpEntity 대신에 block 파라미터를 이용해 toHttpEntity()로 HttpEntity를 생성해보기.
            POST().apply(block).toHttpEntity(),
            responseType
    )

    companion object {
        private const val SCHEMA = "http"
    }
}

class URL {
    private lateinit var host: String
    private var port: Int = 80
    private var path: String = ""

    fun host(host: String) {
        this.host = host
    }

    fun port(port: Int) {
        this.port = port
    }

    fun path(path: String) {
        this.path = path
    }

    override fun toString(): String = "$host:$port$path"
}

class POST : METHOD {
    private val header = HEADER()
    private val body = BODY()

    //TODO: this.body에 적용할 수신객체지정람다를 받아와 실행해주는 메서드를 구현해보기.
    fun body(block: BODY.() -> Unit) {
        body.block()
    }

    override fun header(block: HEADER.() -> Unit) {
        header.block()
    }

    override fun toHttpEntity(): HttpEntity<Any> = HttpEntity(body.map, header.httpHeaders)
}

interface METHOD {
    fun header(block: HEADER.() -> Unit)
    fun toHttpEntity(): HttpEntity<Any>
}

class HEADER {
    val httpHeaders = HttpHeaders()

    //TODO: '+=' 연산자를 이용하도록 변경해보기.
    operator fun String.plusAssign(value: String) {
        httpHeaders[this] = value
    }
}

class BODY {
    val map = mutableMapOf<String, Any>()

    //TODO: 중위 호출 to 로 변경해보기.
    infix fun String.to(value: Any) {
        map[this] = value
    }
}

fun main() {
    //TODO: 이 테스트코드가 동작할 수 있게 URL 클래스를 새로 만들고, Http 클래스를 변경해보기
    val restTemplate = RestTemplateBuilder().build()

    val http = Http(restTemplate)

    val newResult = http {
        host("localhost")
        port(8080)
        path("/test")
    }.post(String::class.java) {
        header { HttpHeaders.CONTENT_TYPE += MediaType.APPLICATION_JSON_VALUE }
        body {
            "key" to "value"
            "what" to "say"
        }
    }

    //TODO: 요기 바깥에서 사용하는 +=는 HEADER 클래스에 새로 정의한 +=가 아닌 것을 확인해보기
    var string = "someString"
    string += MediaType.APPLICATION_JSON_VALUE

    println(newResult.body)
}

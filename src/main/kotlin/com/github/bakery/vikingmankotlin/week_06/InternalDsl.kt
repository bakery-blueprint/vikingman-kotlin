package com.github.bakery.vikingmankotlin.week_06

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForEntity
import org.springframework.web.servlet.function.RequestPredicates.path

class Http(private val restTemplate: RestTemplate) {
    private lateinit var url: String
    private val URL = URL()

    fun url(url: String) = this.apply { this.url = url }

    fun post(responseType: Class<out Any>, block: POST.() -> Unit) = restTemplate.postForEntity(
            url,
            //TODO: 아래 더미 HttpEntity 대신에 block 파라미터를 이용해 toHttpEntity()로 HttpEntity를 생성해보기.
            POST().apply { block(this) }.toHttpEntity(),
            responseType
    )
}

class URL {

}

class POST : METHOD {
    private val header = HEADER()
    private val body = BODY()

    //TODO: this.body에 적용할 함수를 받아와 실행해주는 메서드를 구현해보기.
    fun body(bloock: BODY.() -> Unit) {
        body.bloock()
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
    operator fun String.plusAssign(mediaType: String) {
        httpHeaders[this] = mediaType
    }
}

class BODY {
    val map = mutableMapOf<String, Any>()

    //TODO: 중위 호출 to 로 변경해보기.
    infix fun String.to(value: String) {
        map[this] = value
    }
}



fun main() {
/*    val result = Http(RestTemplate())
            .url("localhost:8080/test")
            .post(String::class.java) {
                header { put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) }
                body {
                    put("key", "value")
                    put("what", "say")
                }
            }*/

    //TODO: 이 테스트코드가 동작할 수 있게 URL 클래스를 새로 만들고, Http 클래스를 변경해보기
    val http = Http(RestTemplate())
    val newResult = http {
                host("localhost")
                port(8080)
                path("/test")
            }
            .post(String::class.java) {
                header { HttpHeaders.CONTENT_TYPE += MediaType.APPLICATION_JSON_VALUE }
                body {
                    "key" to "value"
                    "what" to "say"
                }
            }
}

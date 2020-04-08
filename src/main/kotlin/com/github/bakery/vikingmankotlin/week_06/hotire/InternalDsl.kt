package com.github.bakery.vikingmankotlin.week_06.hotire

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import kotlin.properties.Delegates

class Url {
    lateinit var host: String
    var port by Delegates.notNull<Int>()
    lateinit var path: String

    override fun toString(): String {
        return host + port + path
    }
}

class Http(private val restTemplate: RestTemplate = RestTemplate()) {
    private lateinit var url: String
    private val newUrl = Url()

    fun url(url: String) = this.apply { this.url = url }

    fun post(responseType: Class<out Any>, block: POST.() -> Unit) =
        restTemplate.postForEntity(
                newUrl.toString(),
                POST().apply { block(this) }.toHttpEntity(),
                responseType
        )

    fun host(host: String) {
        newUrl.host = host
    }

    fun path(path: String) {
        newUrl.path = path
    }

    fun port(port: Int) {
        newUrl.port = port
    }

    operator fun invoke(consumer: Http.() -> Unit) : Http {
        consumer(this)
        return this
    }
}

class POST : METHOD {
    private val header = HEADER()
    private val body = BODY()

    fun body(consumer : BODY.() -> Unit) {
        body.consumer()
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

    operator fun String.plusAssign(pair: String) {
        httpHeaders[this] = pair
    }

    fun put(key: String, value: String) {
        httpHeaders[key] = value
    }
}


class BODY {
    val map = mutableMapOf<String, Any>()

    infix fun String.to(value: String) {
        map[this] = value
    }

    fun put(key: String, value: Any) {
        map[key] = value
    }
}

fun main() {
    val result = Http(RestTemplate())
            .url("localhost:8080/test")
            .post(String::class.java) {
                header { put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()) }
                body {
                    put("key", "value")
                    put("what", "say")
                }
            }

    val http = Http()
    val newResult = http {
                host("localhost")
                port(8080)
                path("/test")
            }
            .post(String::class.java) {
                header { HttpHeaders.CONTENT_TYPE += MediaType.APPLICATION_JSON.toString() }
                body {
                    "key" to "value"
                    "what" to "say"
                }
            }
}




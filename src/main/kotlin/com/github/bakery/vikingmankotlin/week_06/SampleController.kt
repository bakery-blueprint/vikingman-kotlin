package com.github.bakery.vikingmankotlin.week_06;

import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {
    @PostMapping("/test")
    fun test(@RequestHeader(HttpHeaders.CONTENT_TYPE) contentType: String,
             @RequestBody body: Map<String, String>): ResponseEntity<Any> {
        println("contentType:$contentType")
        body.forEach { (key, value) -> println("$key:$value") }
        return ResponseEntity.ok("success!")
    }
}

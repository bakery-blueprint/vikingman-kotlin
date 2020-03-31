package com.github.bakery.vikingmankotlin.week_05

import kotlin.reflect.full.findAnnotation

class Reflection(val name: String)

fun main() {
    val reflection = Reflection("")
    val c = Reflection::class.java.kotlin;
    reflection.javaClass.kotlin;

    val custom = Reflection::class.findAnnotation<MyDeprecated>();
    Reflection::class.java.declaredFields
}



//fun <T : Annotation> KAnnotatedElement.findAnnotation2(): T? =
//        @Suppress("UNCHECKED_CAST")
//        annotations.firstOrNull { it is T } as T?



//@SinceKotlin("1.1")
//fun <reified T : Annotation> KAnnotatedElement.findAnnotation3(): T? =
//        @Suppress("UNCHECKED_CAST")
//        annotations.firstOrNull { it is T } as T?
package com.github.hotire.springbootkotlin.books.in_action.ex10

import java.lang.annotation.Inherited
import java.security.MessageDigest
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.superclasses
import kotlin.reflect.KProperty as KProperty1

fun String.sha256(): String {
    return hashString(this, "SHA-256")
}

private fun hashString(input: String, algorithm: String): String {
    return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
}

fun Any.getHash() : String  {
    if (this is HashAware) {
        return getHash()
    }
    return toString()
}

interface HashAware {
    @Inherited
    @Retention
    @Target(AnnotationTarget.PROPERTY)
    annotation class HashCode(val order: Int)

    public fun findAnnotation(kProperty: KProperty1<*>) : HashCode? {
        return kProperty.findAnnotation<HashCode>() ?: this::class.superclasses
                .map { it.declaredMemberProperty(kProperty.name)?.findAnnotation<HashCode>() }
                .firstOrNull()
    }

    fun  hasAnnotation(kProperty: KProperty1<*>): Boolean = findAnnotation(kProperty) != null

    fun getHash() : String {
        return this::class.declaredMemberProperties
                .asSequence()
                .filter { hasAnnotation(it)}
                .sortedBy { findAnnotation(it)!!.order }
                .map { getPrefix() + findAnnotation(it)!!.order + it.call(this)?.getHash() }
                .joinToString()
                .sha256();
    }

    fun getPrefix() : String = this::class.simpleName ?: ""
}

interface PersonHashAware : HashAware {
    @HashAware.HashCode(1)
    val name : String
    @HashAware.HashCode(2)
    val age: Int
}

class PersonEntity(override val name: String, override val age: Int) : PersonHashAware {
    @HashAware.HashCode(3)
    val person: PersonHashAware = object:PersonHashAware {
        override val name: String
            get() = this@PersonEntity.name
        override val age: Int
            get() = this@PersonEntity.age
    }
}




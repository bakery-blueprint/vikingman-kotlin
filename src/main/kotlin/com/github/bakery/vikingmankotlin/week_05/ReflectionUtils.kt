package com.github.hotire.springbootkotlin.books.in_action.ex10

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

fun KClass<*>.declaredMemberProperty(propertyName: String) : kotlin.reflect.KProperty1<out Any, Any?>?
     = this.declaredMemberProperties.firstOrNull { it.name == propertyName }

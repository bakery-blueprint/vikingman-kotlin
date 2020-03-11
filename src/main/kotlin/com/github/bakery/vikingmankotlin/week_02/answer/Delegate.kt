package com.github.bakery.vikingmankotlin.week_02.answer

class LoggingMutableList<E>(private val delegate: MutableList<E>): MutableList<E> by delegate {
    override fun add(element: E): Boolean {
        println(element)
        return delegate.add(element)
    }

    override fun addAll(elements: Collection<E>): Boolean {
        println(elements)
        return delegate.addAll(elements)
    }

    companion object {
        fun <T> of(vararg elements: T) = LoggingMutableList(elements.toMutableList())
    }
}

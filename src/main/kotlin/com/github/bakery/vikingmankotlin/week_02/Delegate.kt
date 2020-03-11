package com.github.bakery.vikingmankotlin.week_02

class LoggingCollections<E> (private val delegate : MutableCollection<E>): MutableCollection<E> by delegate {
    override fun add(element: E): Boolean {
        print(element)
        delegate.add(element)
        return true
    }
}

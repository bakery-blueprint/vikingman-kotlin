package com.github.bakery.vikingmankotlin.week_02.answer

interface Figure {
    val isRegular: Boolean
}

class Rectangle(val height: Int, val width: Int) : Figure {
    override val isRegular: Boolean
        get() = height == width
}

class Triangle(val length1: Int, val length2: Int, val length3: Int) : Figure {
    override val isRegular: Boolean
        get() = length1 == length2 && length2 == length3
}

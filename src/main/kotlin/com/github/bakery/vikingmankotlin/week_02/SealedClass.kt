package com.github.bakery.vikingmankotlin.week_02

// TODO: interface를 sealed class로 변경하고 테스트 해봅시다.
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else ->
                throw IllegalArgumentException("Unknown expression")
        }

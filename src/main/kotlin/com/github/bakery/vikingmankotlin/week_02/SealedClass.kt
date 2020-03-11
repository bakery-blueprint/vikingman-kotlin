package com.github.bakery.vikingmankotlin.week_02

// TODO: interface를 sealed class로 변경하고 테스트 해봅시다.
//interface Expr


fun eval(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.right) + eval(e.left)
        }



sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}


fun  main(){
    val num1 = Expr.Num(1)
    val num2 = Expr.Num(2)

    println(eval(Expr.Sum(num1, num2)))
}
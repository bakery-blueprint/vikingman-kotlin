package com.github.bakery.vikingmankotlin.week_03


class Water(val waterSource: String, var amount: Int = 0){
    /* 안전한 캐스트 연산자를 사용해서 equals을 구현하시오. 수원지(waterSource) 와 양(amount) 이 같으면 동일한 물이라고 판단하시오*/
    override fun equals(o: Any?): Boolean {
        val water = o as? Water ?: return false
        return water.waterSource == waterSource && water.amount == amount
    }
}

fun Water?.isNullOrEmpty(): Boolean =
        this == null || this.waterSource.isEmpty() || this.amount == 0

/* null이 가능한 Water 타입에 isNullOrEmpty 함수를 확장하시오 */


fun  main(){
    val water1 = Water("동해", 100)
    val water2 = Water("동해", 100)

    println(water1 == water2)

    val emptyWater: Water? = null
    println(emptyWater.isNullOrEmpty())
}
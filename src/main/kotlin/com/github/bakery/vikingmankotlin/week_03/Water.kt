package com.github.bakery.vikingmankotlin.week_03


class Water(val waterSource: String, var amount: Int = 0){


    override fun equals(other: Any?): Boolean {
        val otherWater = other as? Water ?: return false

        return otherWater.waterSource == waterSource &&
                otherWater.amount == amount
    }

    fun checkEqualsWaterSoruce(source: Water, other: Water): Boolean {
        if(!other.waterSource.equals(source.waterSource))
            throw IllegalArgumentException("동일한 수원지가 아닙니다!")

        return other.waterSource.equals(source.waterSource)
    }

    operator fun plus(other: Water) : Water {

        checkEqualsWaterSoruce(this, other)

        return Water(waterSource, amount + other.amount)
    }

    operator fun minus(other: Water) : Water {
        checkEqualsWaterSoruce(this, other)
        return Water(waterSource, amount - other.amount)


    }
    /* 안전한 캐스트 연산자를 사용해서 equals을 구현하시오. 수원지(waterSource) 와 양(amount) 이 같으면 동일한 물이라고 판단하시오*/
}

/* null이 가능한 Water 타입에 isNullOrEmpty 함수를 확장하시오 */

fun Water?.isNullOrEmpty(): Boolean =
        this == null || this.amount <= 0

fun  main(){

    val water: Water = Water("제주도", 500)
    val otherWater: Water = Water("제주도", 500)

    println("water.equals(otherWater) : " + water.equals(otherWater))

    val nullWater: Water? = null
    val emptyWater: Water? = Water("제주도", 0)

    println("nullWater.isNullOrEmpty() : " + nullWater.isNullOrEmpty())
    println("emptyWater.isNullOrEmpty() : " + emptyWater.isNullOrEmpty())

}
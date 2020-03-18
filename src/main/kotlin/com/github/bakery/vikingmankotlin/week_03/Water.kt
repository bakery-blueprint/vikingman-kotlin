package com.github.bakery.vikingmankotlin.week_03


class Water(val waterSource: String, var amount: Int = 0){
    /* 안전한 캐스트 연산자를 사용해서 equals을 구현하시오. 수원지(waterSource) 와 양(amount) 이 같으면 동일한 물이라고 판단하시오*/

    override fun equals(other: Any?): Boolean {
        val otherWater = other as? Water ?: return false
        return this.waterSource == otherWater.waterSource
                && this.amount == otherWater.amount
    }

    override fun hashCode(): Int = waterSource.hashCode() * 37 + amount.hashCode()

    operator fun plus(other: Water): Water {
        if (this.waterSource == other.waterSource)
            return Water(this.waterSource, this.amount + other.amount)
        throw IllegalArgumentException("딴데잖아!")
    }

    operator fun minus(other: Water): Water {
        if (this.waterSource == other.waterSource)
            return Water(this.waterSource, this.amount - other.amount)
        throw IllegalArgumentException("딴데잖아!")
    }
}

/* null이 가능한 Water 타입에 isNullOrEmpty 함수를 확장하시오 */
fun Water.isNullOrEmpty(water: Water?): Boolean = water == null || water.amount <= 0

fun  main(){
    val water = Water("some", 100)
}

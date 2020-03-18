package com.github.bakery.vikingmankotlin.week_03


class Water(val waterSource: String, var amount: Int = 0){
    /* 안전한 캐스트 연산자를 사용해서 equals을 구현하시오. 수원지(waterSource) 와 양(amount) 이 같으면 동일한 물이라고 판단하시오*/

    override fun equals(other: Any?) : Boolean {
        if (other is Water) {
            return other.amount == amount && other.waterSource == waterSource ;
        }
        return super.equals(other)
    }
    operator fun plus(other:Water) : Water {
        this.amount += other.amount;
        return this;
    }

    operator fun minus(other:Water) : Water {
        this.amount -= other.amount;
        return this;
    }
}

/* null이 가능한 Water 타입에 isNullOrEmpty 함수를 확장하시오 */


inline fun Water?.isNullOrEmpty() : Boolean = this == null || this.amount == 0


fun  main(){

}
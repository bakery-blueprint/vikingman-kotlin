package com.github.bakery.vikingmankotlin.week_07.homework

import java.text.SimpleDateFormat
import java.util.*

data class Person(val name: String,
                  val dateOfBirth: Date,
                  val address: Address?)

data class Address(val street: String,
                   val number: Int,
                   val city: String)

fun person(block: PersonBuilder.() -> Unit): Person = PersonBuilder().apply(block).build()

class PersonBuilder {

    var name: String = ""
    private var birth: Date = Date()
    var dateOfBirth: String = ""
        set(value) { birth = SimpleDateFormat("yyyy-MM-dd").parse(value) }

    private var address: Address? = null

    fun address(block: AddressBuilder.() -> Unit) {
        address = AddressBuilder().apply(block).build()
    }

    fun build(): Person = Person(name, birth, address)

}


class AddressBuilder {

    var street: String = ""
    var number: Int = 0
    var city: String = ""

    fun build() : Address = Address(street, number, city)

}

fun main(){
    val person = person {
        name = "demo"
        dateOfBirth = "1991-07-6"
        address {
            street = "Pungdeokcheon-ro"
            number = 160
            city = "Yongin-si"
        }
        /*
        // TODO 아래 형태로 수정해서 여러개 주소를 받을 수 있게 만드세용
        addresses {
            address {
                street = "Pungdeokcheon-ro"
                number = 160
                city = "Yongin-si"
            }
            address {
                street = "Pangyoyeok-ro"
                number = 235
                city = "Seongnam-si"
            }
        }
        */
        /*
        // TODO @DslMarker 를 사용해 의도한 dsl 문법이 깨지지 않게 정의하시오
        addresses {
            address {
                addresses {
                    name = "Mary"
                }
                street = "Dev Avenue"
                number = 42
                city = "Paris"
            }
        }
        */

    }
}
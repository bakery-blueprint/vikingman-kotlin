package com.github.bakery.vikingmankotlin.week_07.homework

import java.text.SimpleDateFormat
import java.util.*

@DslMarker
annotation class PersonDsl

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
    private val addresses: MutableList<Address> = mutableListOf()

    fun address(block: AddressBuilder.() -> Unit) {
        address = AddressBuilder().apply(block).build()
    }

    fun addresses(block: AddressBuilder.() -> Unit) {
        addresses.add(AddressBuilder().apply(block).build())
    }

    fun build(): Person = Person(name, birth, address)

}


class ADDRESSES: ArrayList<Address>() {
    fun address(block: AddressBuilder.() -> Unit) {
        add(AddressBuilder().apply(block).build())
    }
}

@PersonDsl
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
    }

    println(person)
}
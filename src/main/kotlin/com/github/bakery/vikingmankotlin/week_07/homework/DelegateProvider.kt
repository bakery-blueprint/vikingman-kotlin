package com.github.bakery.vikingmankotlin.week_07.homework

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


// TODO DelegateProvider 기능을 사용해서 profile에 따른 datasource 를 가지고 오게 만들어 보자(내용은 자유~)

val datasources = mapOf("prod" to mapOf("name" to "jaehyun"), "dev" to mapOf("name" to "demo"))

class DataSourceFactory(profile: String) {
    val datasource: Map<String, String> by DataSourceDelegateProvider(profile)


}

class DataSourceDelegateProvider(profile: String) : ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
    operator fun provideDelegate(thisRef: DataSourceFactory, prop: KProperty<*>) : ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
            return object : ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
                override fun getValue(thisRef: DataSourceFactory, property: KProperty<*>): Map<String, String> {
                    return datasources[prop.name] ?: mapOf()
                }
    }

}

fun main() {
    val dataSourceFactory = DataSourceFactory("prod")
    println(dataSourceFactory.datasource["name"])
}

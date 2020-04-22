package com.github.bakery.vikingmankotlin.week_07.homework

import javafx.beans.property.ReadOnlyProperty
import kotlin.reflect.KProperty


// TODO DelegateProvider 기능을 사용해서 profile에 따른 datasource 를 가지고 오게 만들어 보자(내용은 자유~)

val datasource = mapOf("prod" to mapOf("name" to "jaehyun"), "dev" to mapOf("name" to "demo"))

class DataSourceFactory(profile: String) {
    val datasource by DatasourceDelegateProvider(profile)
}

class DatasourceDelegateProvider(profile: String) {
    operator fun provideDelegate(
            thisRef: DataSourceFactory,
            prop: KProperty<*>
    ): ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
        return object: ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
            override fun getValue(thisRef, DataSourceFactory, property: KProperty<*>)
                    : Map<String, String> {

            }

        }

    }
}


fun main(){
    val dataSourceFactory = DataSourceFactory("prod")
    println(dataSourceFactory.datasource.get("name"))
}

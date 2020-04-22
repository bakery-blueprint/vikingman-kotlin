package com.github.bakery.vikingmankotlin.week_07.homework.answer

import java.lang.IllegalArgumentException
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


val datasource = mapOf("prod" to mapOf("name" to "jaehyun"), "dev" to mapOf("name" to "demo"))


class DataSourceService(val profileName: String) {
   fun getDatasource(): Map<String, String> = datasource[profileName]?:throw NullPointerException()
}

class DataSourceFactory(val profileName: String){
    val datasource by DataSourceDelegateProvider(profileName)
}

class DataSourceDelegateProvider(val profileName: String ) {
    operator fun provideDelegate(
            thisRef:DataSourceFactory,
            prop: KProperty<*>): ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
        if(profileName == "prod" || profileName == "dev"){
            return object: ReadOnlyProperty<DataSourceFactory, Map<String, String>> {
                override fun getValue(thisRef: DataSourceFactory, property: KProperty<*>): Map<String, String> {
                    return DataSourceService(profileName).getDatasource()
                }
            }
        } else {
            throw IllegalArgumentException("Please enter only two environments : dev, prod")
        }
    }
}

fun main(){
    println(DataSourceFactory("dev").datasource.get("name"))
    println(DataSourceFactory("prod").datasource.get("name"))
}


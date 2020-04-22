package com.github.bakery.vikingmankotlin.week_07.homework


val datasourceProvider = mapOf("prod" to mapOf("name" to "jaehyun"), "dev" to mapOf("name" to "demo"))

class DataSourceFactory(val profile : String){
    val datasource by datasourceProvider[profile]
}


fun main(){
    val dataSourceFactory = DataSourceFactory("prod")
    print(dataSourceFactory.datasource.get(1))
}
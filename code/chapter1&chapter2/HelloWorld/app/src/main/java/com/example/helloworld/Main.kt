package com.example.helloworld

import java.util.*

class Main {
}
fun main() {
    /*// listOf函数创建的是一个不可变的集合
    val list = listOf("Banana","Apple","Orange","Pear","Grape")
    // mutableListOf创建的是一个可变的集合
    val list2 = mutableListOf("Banana","Apple","Orange","Pear","Grape")
    list2.add("Watermelon")
    for (fruit in list2) {
        println(fruit)
    }*/

    /*val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3
    map["Pear"] = 4
    map["Grape"] = 5

    val map2 = mapOf("Apple" to 1,"Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    for ((fruit, number) in map2) {
        println("fruit is $fruit, number is $number")
    }*/

    // 【Lambda编程】
    // filter和map均为函数，又称为函数式API
    val list = listOf("Banana","Apple","Orange","Pear","Grape","Watermelon")
    /*val newList = list.filter { it.length <= 5 }.map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }*/

    // 集合中是否存在5个字母以内的单词
    val anyResult = list.any{it.length <= 5}
    // 集合中是否所有单词都在5个字母以内
    val allResult = list.all { it.length <= 5 }
    println("anyResult is $anyResult, allResult is $allResult")

}
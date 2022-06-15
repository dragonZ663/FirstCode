package com.example.helloworld

import kotlin.math.max

fun main() {
    /*val num = 10L
    checkNumber(num)*/

    // for-in循环
    /*for (i in 0..10) {
        println(i)
    }*/
    // 单端闭区间[0,10)
    /*for (i in 0 until 10) {
        println(i)
    }*/
    // 每一步递增2,相当于i = i + 2
   /* for (i in 0 until 10 step 2) {
        println(i)
    }*/
    // 降序遍历
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}
// 语法糖
fun largerNumber2(num1: Int, num2: Int): Int = max(num1, num2)
fun largerNumber3(num1: Int, num2: Int) = max(num1, num2)

// 【if语句】
// if是有返回值的，返回值为if语句中每个条件的最后一行代码的返回值
fun largerNumber4(num1: Int, num2: Int): Int {
    val value = if (num1 > num2) {
        num1
    }else{
        num2
    }
    return value
}
fun largerNumber5(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    }else{
        num2
    }
}
fun largerNumber6(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

// 【when语句】
fun getScore(name: String) = if (name == "Tom") {
    86
}else if (name == "Jim") {
    77
}else if (name == "Jack") {
    95
}else if (name == "Lily") {
    100
}else {
    0
}

fun getScore2(name: String) = when (name) {
    "Tom" -> {
        86
    }
    "Jim" -> {
        77
    }
    "Jack" -> {
        95
    }
    "Lily" -> {
        100
    }
    else -> {
        0
    }
}
// 类型匹配
 fun checkNumber(num: Number) {
     when (num) {
         is Int -> println("number is Int")
         is Double -> println("number is Double")
         else -> println("number is not support")
     }
 }
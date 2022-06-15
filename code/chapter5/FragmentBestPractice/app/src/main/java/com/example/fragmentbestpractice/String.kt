package com.example.fragmentbestpractice

/**
 * 扩展函数
 */
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

/**
 * 重载运算符* ， 同时对String类进行函数扩展
 */
operator fun String.times(n: Int): String {
    val builder = StringBuilder()
    repeat(n) {
        builder.append(this)
    }
    return builder.toString()
}

fun main() {
    val str = "abd" * 3
    println(str)
}
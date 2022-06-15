package com.example.helloworld

interface Study {
    fun readBooks()
    // Kotlin还增加了一个额外的功能：允许对接口中定义的函数进行默认实现
    fun doHomework() {
        println("do homework default implementation")
    }
}
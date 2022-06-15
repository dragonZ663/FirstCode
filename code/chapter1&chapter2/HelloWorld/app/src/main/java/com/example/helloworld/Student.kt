package com.example.helloworld

// Person加上（）表示子类调用父类的构造函数
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study{
    init {
        println("sno is $sno")
        println("grade is $grade")
    }
    // 第一个次构造函数，通过this调用了主构造函数，把sno和grade进行初始化
    constructor(name: String, age: Int) : this("",0,name,age){

    }
    // 第二个次构造函数，通过this调用了第一个构造函数，吧name和age进行初始化
    constructor() : this("",0){

    }

    override fun readBooks() {
        println("$name is reading")
    }

    /*override fun doHomework() {
        println("$name is doing homework")
    }*/
}

/*fun main() {
   *//* // 调用主构造函数
    val student = Student("a123",5,"Jack",19)
    // 调用第一个构造函数
    val student2 = Student("Jack", 19)
    // 调用第二个构造函数
    val student3 = Student()*//*

    val student = Student("Jack",19)
    doStudy(student)
}
fun doStudy(study: Study){
    study.readBooks()
    study.doHomework()
}*/
package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// 1.MainActivity是继承自AppCompatActivity的
// 2.AppCompatActivity是AndroidX中提供的一种向下兼容的Activity，可以使Activity在不同系统版本中的功能保持一致性
// 3.Activity类是Android系统提供的一个基类，我们项目中所有自定义的Activity都必须继承它或者它的子类,
//   才能拥有Activity的特性（AppCompatActivity是Activity的子类）
class MainActivity : AppCompatActivity() {
    // onCreate方法是一个Activity被创建时必定要执行的方法
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView()方法给当前的Activity引入了一个activity_main布局
        setContentView(R.layout.activity_main)
        // Log传入两个参数，一个参数是tag，一般传入当前的类名就好，主要用于对打印信息进行过滤;第二个参数是msg，即想要打印的具体内容。
        Log.d("MainActivity","onCreate execute")
    }
}
package com.example.uicustomviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

/**
 * 自定义控件——标题栏
 */
class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title, this)
        val back: Button = findViewById(R.id.titleBack)
        back.setOnClickListener {
            // as 强制类型转换
            val activity = context as Activity
            activity.finish()
        }

        val edit: Button = findViewById(R.id.titleEdit)
        edit.setOnClickListener {
            Toast.makeText(context, "You clicked Edit Button", Toast.LENGTH_SHORT).show()
        }
    }
}
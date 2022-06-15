package com.example.sharedpreferencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            /*val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
            editor.apply()*/

            /*getSharedPreferences("data", Context.MODE_PRIVATE).open {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }*/
            // KTX库内置方法
            getSharedPreferences("data", Context.MODE_PRIVATE).edit {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }

        }

        findViewById<Button>(R.id.restoreButton).setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name","")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d("MainActivity", "name is $name")
            Log.d("MainActivity", "age is $age")
            Log.d("MainActivity", "married is $married")
        }
    }
}
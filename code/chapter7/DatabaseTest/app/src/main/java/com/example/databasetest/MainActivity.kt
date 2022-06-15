package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.contentValuesOf
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)

        findViewById<Button>(R.id.createDatabase).setOnClickListener {
            dbHelper.writableDatabase
        }

        findViewById<Button>(R.id.addData).setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                // 开始组装第一条数据
                put("author", "Dan Brown")
                put("name", "The Da Vinci Code")
                put("pages", 454)
                put("price", 16.96)
            }
            // 插入第一条数据
            db.insert("Book", null, values1)
            val values2 = ContentValues().apply {
                // 开始组装第二条数据
                put("author", "Dan Brown2")
                put("name", "The Lost Symbol")
                put("pages", 510)
                put("price", 19.95)
            }
            // 插入第二条数据
            db.insert("Book", null, values2)
        }

        findViewById<Button>(R.id.updateData).setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name=?", arrayOf("The Da Vinci Code"))
        }

        findViewById<Button>(R.id.deleteData).setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book", "pages > ?", arrayOf("500"))
        }

        findViewById<Button>(R.id.queryData).setOnClickListener {
            val db = dbHelper.writableDatabase
            val cursor = db.query("Book", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(maxOf(cursor.getColumnIndex("name"), 0))
                    val author = cursor.getString(maxOf(cursor.getColumnIndex("author"), 0))
                    val pages = cursor.getInt(maxOf(cursor.getColumnIndex("pages"), 0))
                    val price = cursor.getDouble(maxOf(cursor.getColumnIndex("price"), 0))
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "book author is $author")
                    Log.d("MainActivity", "book pages is $pages")
                    Log.d("MainActivity", "book price is $price")

                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        findViewById<Button>(R.id.replaceData).setOnClickListener {
            val db = dbHelper.writableDatabase
            // 开启事务
            db.beginTransaction()
            try {
                db.delete("Book", null, null)
                /*if (true) {
                    // 手动抛出一个异常
                    throw NullPointerException()
                }*/
                /*val values = ContentValues().apply {
                    put("name", "Game of Thrones")
                    put("author", "George Martin")
                    put("pages", 720)
                    put("price", 20.85)
                }*/
                val values = cvOf(
                    "name" to "Game of Thrones", "author" to "George Martin",
                    "pages" to 720, "price" to 20.85
                )
                // KTX库内置方法
                val values2 = contentValuesOf(
                    "name" to "Game of Thrones", "author" to "George Martin",
                    "pages" to 720, "price" to 20.85
                )
                db.insert("Book", null, values)
                // 事务已经执行成功
                db.setTransactionSuccessful()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                // 结束事务
                db.endTransaction()
            }
        }
    }
}
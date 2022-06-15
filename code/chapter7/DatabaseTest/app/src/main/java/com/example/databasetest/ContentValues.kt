package com.example.databasetest

import android.content.ContentValues

fun cvOf(vararg pairs: Pair<String, Any?>) = ContentValues().apply {
    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            // 这里还使用了Kotlin中的Smart Cast功能
            // 比如when语句进入Int条件分支后，这个条件下面的value会被自动转换成Int类型，而不再是Any?类型
            is Int -> put(key, value)
            is Long -> put(key, value)
            is Short -> put(key, value)
            is Float -> put(key, value)
            is Double -> put(key, value)
            is Boolean -> put(key, value)
            is String -> put(key, value)
            is Byte -> put(key, value)
            is ByteArray -> put(key, value)
            null -> putNull(key)
        }
    }
}
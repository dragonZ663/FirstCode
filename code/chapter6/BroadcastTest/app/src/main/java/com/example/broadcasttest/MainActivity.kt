package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var timeChangReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent("com.example.broadcasttest.MY_BROADCAST")
            // 指定这条广播是发送给哪个应用程序的，进而将自定义广播（隐式广播）变成显式广播，否则静态注册的广播是无法接收到这条广播的
            intent.setPackage(packageName)
            // 发送标准广播（无序，异步）
//            sendBroadcast(intent)
            // 发送有序广播
            sendOrderedBroadcast(intent, null)
        }

        val intentFilter = IntentFilter()
        // 当系统时间发生变化时，系统发出的正是一条值为android.intent.action.TIME_TICK的广播,
        // 也就是说我们的BroadcastReceiver想要监听什么广播，就在这里添加相应的action
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangReceiver = TimeChangeReceiver()
        // 注册
        registerReceiver(timeChangReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }
    }
}
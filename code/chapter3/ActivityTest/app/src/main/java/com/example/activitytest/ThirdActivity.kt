package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.ThirdLayoutBinding

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity","task id is $taskId")
        val binding = ThirdLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener{
            ActivityCollector.finishAll()
            // killProcess用于杀掉一个进程，通过myPid()方法获取当前程序的进程id
            // 【注】killProcess只能杀掉当前进程，不能杀掉其他进程
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}
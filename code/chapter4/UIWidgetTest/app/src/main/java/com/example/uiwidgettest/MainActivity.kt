package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.uiwidgettest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /* // 方式1
         binding.button.setOnClickListener{
             // to do
         }*/
        // 方式2
        binding.button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                /*val inputText = binding.editText.text.toString()
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()*/
                //binding.imageView.setImageResource(R.drawable.img_2)
                /*if(binding.processBar.visibility == View.VISIBLE) {
                    binding.processBar.visibility = View.GONE
                }else {
                    binding.processBar.visibility = View.VISIBLE
                }*/
                //binding.processBar.progress += 10
                AlertDialog.Builder(this).apply {
                    // 设置标题
                    setTitle("This is a Dialog")
                    // 内容
                    setMessage("Something Important")
                    // 可否使用Back键关闭对话框
                    setCancelable(false)
                    // 确定按钮的点击事件
                    setPositiveButton("OK") {
                        dialog, which ->
                    }
                    // 取消按钮的点击事件
                    setNegativeButton("Cancel") {
                        dialog, which ->
                    }
                    // 将对话框显示出来
                    show()
                }
            }
        }
    }
}
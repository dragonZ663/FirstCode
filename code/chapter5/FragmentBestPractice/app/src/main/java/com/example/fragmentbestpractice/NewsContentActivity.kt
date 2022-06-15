package com.example.fragmentbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class NewsContentActivity : AppCompatActivity() {
    private val TAG = "NewsContentActivity"
    companion object {
        fun actionStart(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java)
                .apply {
                    putExtra("news_title", title)
                    putExtra("news_content",content)
                }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        Log.d(TAG, "title=$title, content=$content")
        if (title != null && content != null) {
            Log.d(TAG, "刷新标题和内容")
            // 从布局文件中获取Fragment的实例
            // R.id.newsContentFrag指向activity_news_content.xml中的<fragment>，此时只这一个<fragment>存在
            val newsContentFrag = supportFragmentManager.findFragmentById(R.id.newsContentFrag)
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title, content, false) //刷新NewsContentFragment界面
        }
    }
}
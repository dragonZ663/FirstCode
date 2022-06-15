package com.example.fragmentbestpractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsContentFragment : Fragment() {
    private val TAG = "NewsContentFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_content_frag, container, false)
    }

    /**
     * 用于将新闻的标题和内容显示在新闻内容界面上,双页模式
     */
    fun refresh(title: String, content: String, isTwoPanel: Boolean) {
        if (activity != null) {
            // 获取和当前Fragment相关联的Activity实例
            val mainActivity = if (isTwoPanel) {
                activity as MainActivity
            } else {
                activity as NewsContentActivity
            }
            val contentLayout: LinearLayout = mainActivity.findViewById(R.id.contentLayout)
            contentLayout.visibility = View.VISIBLE
            // 刷新新闻的标题
            val newsTitle: TextView = mainActivity.findViewById(R.id.newsTitle)
            newsTitle.text = title
            // 刷新新闻的内容
            val newsContent: TextView = mainActivity.findViewById(R.id.newsContent)
            newsContent.text = content
        }
    }
}
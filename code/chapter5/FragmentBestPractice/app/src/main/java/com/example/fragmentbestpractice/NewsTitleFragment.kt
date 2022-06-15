package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.StringBuilder

class NewsTitleFragment : Fragment() {
    private var isTwoPane = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag, container, false)
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News("This is news title $i", getRandomString("This is news content $i"))
            newsList.add(news)
        }
        return newsList
    }
    /*private fun getRandomString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }*/

    private fun getRandomString(str: String) = str * (1..20).random()

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // 根据ID为newsContentLayout的组件存在情况，判断是否是双面板
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
        // 配置RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        if (activity != null) {
            val mainActivity = activity as MainActivity
            val newsTitleRecyclerView: RecyclerView = mainActivity.findViewById(R.id.newsTitleRecyclerView)
            newsTitleRecyclerView.layoutManager = layoutManager
            val adapter = NewsAdapter(getNews())
            newsTitleRecyclerView.adapter = adapter
        }

    }

    // 适配器类（内部类）
    inner class NewsAdapter(private val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        // 自定义ViewHolder类
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitleItem)
        }

        // 获取ViewHolder实例
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            // Item点击事件
            holder.itemView.setOnClickListener{
                val news = newsList[holder.adapterPosition]
                if (isTwoPane) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
                    // R.id.newsContentFrag指向layout-sw600dp\activity_main.xml中的<fragment>，此时只这一个<fragment>存在
                    val fragment = fragmentManager?.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refresh(news.title, news.content, isTwoPane)
                }else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }
            return holder
        }

        // Item滚动到屏幕时执行
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount() = newsList.size
    }
}
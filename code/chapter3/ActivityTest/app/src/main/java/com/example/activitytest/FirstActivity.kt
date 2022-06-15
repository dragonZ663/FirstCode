package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", "task id is $taskId")
        // 首先我们要调用first_layout.xml布局文件对应的Binding类，也就是FirstLayoutBinding的inflate()函数去加载该布局，
        // inflate()函数接收一个LayoutInflater参数,在Activity中是可以直接获取到的
        val binding = FirstLayoutBinding.inflate(layoutInflater)
        // 调用Binding类的getRoot()函数可以得到activity_main.xml中根元素的实例
        //  设置activity布局内容
        setContentView(binding.root)
        // 通过bind获取组件button1，并设置按钮监听事件
        binding.button1.setOnClickListener {
            // 传入3个参数，第一个是Context（上下文），第二个是Toast显示的文本内容，第三个是Toast显示的时长
            // Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
            // 销毁当前Activity
            // finish()

            /*// 隐式启动Activity
            val intent = Intent("com.example.activitytest.ACTION_START")
            intent.addCategory("com.example.activitytest.MY_CATEGORY")
            startActivity(intent)*/

            /*// 打开网页
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)*/

            /*// 打开拨号界面
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)*/

            /*val data = "Hello SecondActivity"
            val intent = Intent(this, SecondActivity::class.java)
            // 传递数据(key,value)
            intent.putExtra("extra_data",data)
            startActivity(intent)*/

            /*val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)*/

            /*val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)*/
            SecondActivity.actionStart(this, "data1", "data2")
        }

        /*
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        // 通过findViewById()方法获取在布局文件中定义的元素
         val button1: Button = findViewById(R.id.button1)
         // 设置按钮监听事件
         button1.setOnClickListener {
             // 传入3个参数，第一个是Context（上下文），第二个是Toast显示的文本内容，第三个是Toast显示的时长
             Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
         }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // 实际上是调用了父类的getMenuInflater()方法
        // getMenuInflater()方法能够得到一个MenuInflater对象，再调用它的inflate()方法，就可以给当前Activity创建菜单了
        menuInflater.inflate(R.menu.main, menu)
        // 返回true表示允许创建的菜单显示出来
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart")
    }
}

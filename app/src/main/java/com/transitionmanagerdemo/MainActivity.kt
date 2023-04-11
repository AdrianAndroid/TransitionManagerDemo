package com.transitionmanagerdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat

/**
 * 参考资料:https://blog.csdn.net/sinat_31057219/article/details/104798443/
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.image).setOnClickListener {
            makeSceneTransitionAnimator()
        }
    }

    private fun makeSceneTransitionAnimator() {
        val intent = Intent(this, SecondActivity::class.java)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val image = findViewById<ImageView>(R.id.image)
            val textView = findViewById<TextView>(R.id.textView)

            val imagePair = androidx.core.util.Pair<View, String>(image, "image")
            val textPair = androidx.core.util.Pair<View, String>(textView, "textView")

            // 单个view联动
            //            val activityOptions =
//                ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    this,
//                    image,
//                    "image"
//                )
            // 多个View联动
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imagePair)
            ActivityCompat.startActivity(this, Intent(this, SecondActivity::class.java), activityOptions.toBundle())
        } else {
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
}
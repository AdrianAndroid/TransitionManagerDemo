package com.transitionmanagerdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat

class SecondActivity : AppCompatActivity() {

    private var transition: Transition? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initTransition()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed()
        } else {
            finish()
            overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
        }
    }

    private fun initTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val textView = findViewById<TextView>(R.id.textView)
            val image = findViewById<ImageView>(R.id.image)

            postponeEnterTransition()
            ViewCompat.setTransitionName(image, "image")
            ViewCompat.setTransitionName(textView, "textView")
            addTransitionListener()
            startPostponedEnterTransition()
        }
    }

    private fun addTransitionListener() {
        transition = window.sharedElementEnterTransition
        transition?.addListener(object : Transition.TransitionListener{
            override fun onTransitionStart(p0: Transition?) {
            }

            override fun onTransitionEnd(p0: Transition?) {
            }

            override fun onTransitionCancel(p0: Transition?) {
            }

            override fun onTransitionPause(p0: Transition?) {
            }

            override fun onTransitionResume(p0: Transition?) {
            }

        })
    }
}
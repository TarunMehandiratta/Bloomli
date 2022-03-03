package com.sf.bloomli.activities.gamifyscreens

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.activity_gamify_welcome_screen.*

class GamifyWelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamify_welcome_screen)
        if(Build.VERSION.SDK_INT >= 21) {
            val window = window
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                        or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
            )
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
//            window.navigationBarColor = Color.TRANSPARENT
        }
        setClick()
    }

    private fun setClick() {
        tvTitle.visibility = View.GONE
        icBack.setOnClickListener {
            onBackPressed()
        }
        takeQuiz.setOnClickListener {
            startActivity(Intent(this,TakeQuizFragment::class.java))
        }
        submitQuiz.setOnClickListener {
            startActivity(Intent(this,SubmitQuizFragment::class.java))
        }
    }
}
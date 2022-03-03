package com.sf.bloomli.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.MyQuizzesAdapter
import com.sf.bloomli.adapters.QuizFragAdapter
import kotlinx.android.synthetic.main.activity_live_quizzes_screen.*
import kotlinx.android.synthetic.main.activity_my_quiz_screen.*
import kotlinx.android.synthetic.main.activity_my_quiz_screen.my_quizzes_recycler

class LiveQuizzesScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_quizzes_screen)
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


        init()
    }

    @SuppressLint("WrongConstant")
    private fun init(){

        //set onClick listener
        quiz_three_dots_icon.setOnClickListener {
            onBackPressed()
        }

        //set adapter
        quiz_frag_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        quiz_frag_recycler.adapter = QuizFragAdapter(this)


        //set onClick listener
        quiz_pink_bell.setOnClickListener {
            val  intent = Intent(this,MessagesScreen::class.java)
            startActivity(intent)
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
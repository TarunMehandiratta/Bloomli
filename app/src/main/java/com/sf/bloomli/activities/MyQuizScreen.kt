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
import kotlinx.android.synthetic.main.activity_my_quiz_screen.*

class MyQuizScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_quiz_screen)
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

        init()
    }

    @SuppressLint("WrongConstant")
    private fun init(){

        //set adapter
        my_quizzes_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        my_quizzes_recycler.adapter = MyQuizzesAdapter(this)

        //set adapter
        my_quizzes_recycler_two.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        my_quizzes_recycler_two.adapter = MyQuizzesAdapter(this)

        //set onClick Listener
        create_new_quiz_text.setOnClickListener {
            val intent = Intent(this,CreateNewQuizScreen::class.java)
            startActivity(intent)
        }
        tvtwiceShy.setOnClickListener {
            startActivity(Intent(this,ScheduleTimeActivity::class.java))
        }

        //set on click listener
        my_quizzes_back_icon.setOnClickListener {
            onBackPressed()
        }
    }
    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
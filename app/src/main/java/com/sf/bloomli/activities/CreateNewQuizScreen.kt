package com.sf.bloomli.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.activity_create_new_quiz_screen.*

class CreateNewQuizScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_quiz_screen)

        setReadioButtonclick()
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

    override fun onResume() {
        super.onResume()
        schedule_text.setTextColor(ContextCompat.getColor(this@CreateNewQuizScreen,R.color.silver))

    }

    private fun setReadioButtonclick() {
        scheduleRadioBut.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                schedule_text.setTextColor(ContextCompat.getColor(this@CreateNewQuizScreen,R.color.app_pink))
                startActivity(Intent(this@CreateNewQuizScreen,ScheduleTimeActivity::class.java))
            }

        })
    }

    @SuppressLint("ResourceAsColor")
    private fun init(){

        //set onClick Listener
        create_new_quiz_back_icon.setOnClickListener {
            onBackPressed()
        }

        //set on click listener
        add_qa_lay.setOnClickListener {
            //visibilities gone or visible
            text_new.setTextColor(Color.parseColor("#FF000000"))
            edit_text.visibility=View.VISIBLE
            edit_text2.visibility=View.VISIBLE
            add_aq_view.visibility=View.VISIBLE
            cancel_add_btn_lay.visibility=View.VISIBLE
            ///////////////////////////////////////
            text_new2.setTextColor(Color.parseColor("#D8D8D8"))
            add_mcq_view.visibility=View.GONE
            edit_text_add_mcq.visibility=View.GONE
            edit_text_add_mcq2.visibility=View.GONE
            add_choice_lay.visibility=View.GONE

        }

        //set on click listener
        add_mcq_lay.setOnClickListener {
            //visibilities gone or visible
            text_new.setTextColor(Color.parseColor("#D8D8D8"))
            edit_text.visibility=View.GONE
            edit_text2.visibility=View.GONE
            add_aq_view.visibility=View.GONE
            cancel_add_btn_lay.visibility=View.GONE
            ////////////////////////////////////
            text_new2.setTextColor(Color.parseColor("#FF000000"))
            add_mcq_view.visibility=View.VISIBLE
            edit_text_add_mcq.visibility=View.VISIBLE
            edit_text_add_mcq2.visibility=View.VISIBLE
            add_choice_lay.visibility=View.VISIBLE
            cancel_add_btn_lay.visibility=View.VISIBLE

        }

        //set on click listener
        continue_btn_create_quiz.setOnClickListener {
            //use intent
           // val intent = Intent(this,CreateNewQuizScheduleScreen::class.java)
            val intent = Intent(this,ScheduleTimeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
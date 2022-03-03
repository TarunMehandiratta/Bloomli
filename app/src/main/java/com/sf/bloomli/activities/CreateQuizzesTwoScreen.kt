package com.sf.bloomli.activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.CreateQuizzesTwoAdapter
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.*
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.add_aq_view
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.add_choice_lay
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.add_mcq_lay
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.add_mcq_view
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.add_qa_lay
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.cancel_add_btn_lay
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.cancel_lay
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.continue_btn_create_quiz
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.edit_text
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.edit_text2
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.edit_text_add_mcq
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.edit_text_add_mcq2
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.text_new
import kotlinx.android.synthetic.main.activity_create_quizzes_two_screen.text_new2
import kotlinx.android.synthetic.main.mcq_popup.*
import kotlinx.android.synthetic.main.question_popup.*

class CreateQuizzesTwoScreen : AppCompatActivity(), CreateQuizzesTwoAdapter.EditClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quizzes_two_screen)
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
        scheduleRadioBut.setChecked(false)
        schedule_text.setTextColor(ContextCompat.getColor(this@CreateQuizzesTwoScreen,R.color.silver))

    }

    private fun init(){

        scheduleRadioBut.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if(p1){
                    schedule_text.setTextColor(ContextCompat.getColor(this@CreateQuizzesTwoScreen,R.color.app_pink))
                    startActivity(
                        Intent(this@CreateQuizzesTwoScreen,
                        ScheduleTimeActivity::class.java)
                    )
                }
            }


        })


        //set on click listener
        create_new_quiz_back_icon_.setOnClickListener {
            onBackPressed()
        }

        //set adapter message_screen_recycler
        qun_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        qun_recycler.adapter = CreateQuizzesTwoAdapter(this,this)


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

    ///on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun showQuestionPopup() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(false)
        dialogData.setContentView(R.layout.question_popup)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogData.cancel_lay.setOnClickListener {
            dialogData.dismiss()
        }

        dialogData.show()

    }


    private fun showMcqPopup() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(false)
        dialogData.setContentView(R.layout.mcq_popup)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogData.cancel_lay_mcq.setOnClickListener {
            dialogData.dismiss()
        }

        dialogData.show()

    }

    override fun onEditClick(position: Int, type: String) {
        if(type.equals("editQues")){
            showQuestionPopup()
        }
        else{
            showMcqPopup()
        }
    }
}
package com.sf.bloomli.activities

import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.RepeatQuizAdapter
import kotlinx.android.synthetic.main.activity_schedule_time.*
import kotlinx.android.synthetic.main.create_new_list_popup.*
import kotlinx.android.synthetic.main.repeat_quiz_dialog.*
import kotlinx.android.synthetic.main.select_date_dialog.*
import kotlinx.android.synthetic.main.select_date_dialog.doneBut
import kotlinx.android.synthetic.main.select_time_popup.*

class ScheduleTimeActivity : AppCompatActivity() {
    var adapter : RepeatQuizAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_time)
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

    private fun init(){

        //set on click listener
        create_new_quiz_tittle_lay.setOnClickListener {
            onBackPressed()
        }

        select_day_lay.setOnClickListener {
            showDateDialog()
        }

        select_time_lay.setOnClickListener {
            showTimeDialog()
        }

        repeat_quiz_lay.setOnClickListener {
            showRepeatDialog()
        }

        add_to_my_quiz_btn.setOnClickListener {
             showNewListPopup()
        }

        add_to_my_quiz_btn2.setOnClickListener {
            showNewListPopup()
        }
        create_new_quiz_back_icon.setOnClickListener {
            onBackPressed()
        }

    }

    private fun showNewListPopup() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(true)
        dialogData.setContentView(R.layout.create_new_list_popup)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        adapter = RepeatQuizAdapter(this)
        dialogData.recycleExistingQuiz.adapter = adapter

        dialogData.addNow.setOnClickListener {
            dialogData.dismiss()
        }

        dialogData.show()
    }

    private fun showRepeatDialog() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(true)
        dialogData.setContentView(R.layout.repeat_quiz_dialog)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        adapter = RepeatQuizAdapter(this)
        dialogData.quizItems.adapter = adapter
        dialogData.repeat_cncle_icon.setOnClickListener{
            dialogData.dismiss()
        }

        dialogData.show()


    }

    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun showDateDialog() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(true)
        dialogData.setContentView(R.layout.select_date_dialog)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogData.date_cncle_icon.setOnClickListener{
            dialogData.dismiss()
        }


        dialogData.show()
    }

    private fun showTimeDialog() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(true)
        dialogData.setContentView(R.layout.select_time_popup)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogData.time_cncle_icon.setOnClickListener {
            dialogData.dismiss()
        }

        dialogData.show()
    }


}
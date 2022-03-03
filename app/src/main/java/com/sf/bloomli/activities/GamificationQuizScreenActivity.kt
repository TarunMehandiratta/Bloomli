package com.sf.bloomli.activities

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
import androidx.core.content.ContextCompat
import com.sf.bloomli.R
import com.sf.bloomli.adapters.QuestionAdapter
import com.sf.bloomli.listeners.QuestionClick
import kotlinx.android.synthetic.main.activity_gamification_quiz_screen.*
import kotlinx.android.synthetic.main.congratulations_gamification_popup.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class GamificationQuizScreenActivity : AppCompatActivity(), QuestionClick {
    private var adapter : QuestionAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamification_quiz_screen)
        if (Build.VERSION.SDK_INT >= 21) {
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
        setToolbar()
        setAdapter()
        setClick()
    }

    private fun setClick() {
        startQuiz.setOnClickListener {
            startQuiz.visibility = View.GONE
            recycleQuests.visibility = View.VISIBLE
        }
    }

    private fun setAdapter() {
        adapter = QuestionAdapter(this,this)
        recycleQuests.adapter = adapter

    }

    private fun setToolbar() {
        tvTitle.setText(getString(R.string.build_confidence_quiz))
        tvTitle.setTextColor(ContextCompat.getColor(this,R.color.white))
        icBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onClick(position: Int) {
        showCongroDialog()
    }

    private fun showCongroDialog() {
        val dialogData = Dialog(this)
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(true)
        dialogData.setContentView(R.layout.congratulations_gamification_popup)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogData.doneBut.setOnClickListener {
            dialogData.dismiss()

            onBackPressed()

        }

        dialogData.show()
    }
}
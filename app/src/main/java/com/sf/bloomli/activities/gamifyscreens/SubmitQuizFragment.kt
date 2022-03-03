package com.sf.bloomli.activities.gamifyscreens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.sf.bloomli.R
import com.sf.bloomli.activities.MyQuizScreen
import com.sf.bloomli.adapters.gamesAdapters.ExistingQuestionsAdapter
import kotlinx.android.synthetic.main.fragment_submit_quiz.*


class SubmitQuizFragment : AppCompatActivity() {
    var adapter : ExistingQuestionsAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_submit_quiz)
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

        setClick()
        setAdapter()
    }

    private fun setAdapter() {
        adapter = ExistingQuestionsAdapter(this)
        existingQuestion.adapter = adapter
    }

    private fun setClick() {
        icBack.setOnClickListener {
            onBackPressed()
        }
        tvTitle.setText(getString(R.string.create_submit_quiz))

        existingQues.setOnClickListener {
//            existingQuestions.visibility = View.VISIBLE
            showPopup(existingQues)


        }
        submitBut.setOnClickListener {
            startActivity(Intent(this, MyQuizScreen::class.java))
        }
    }

    @SuppressLint("ServiceCast")
    private fun showPopup(v: View) {

        val popupWindow = PopupWindow(v)
        val inflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = inflater.inflate(R.layout.add_existing_quiz_popup, null)

//        val item: TextView = view.findViewById(R.id.edit_profile_text) as TextView
//        val item2: TextView = view.findViewById(R.id.message_text) as TextView
//        val item3: TextView = view.findViewById(R.id.feedback_text) as TextView
//
//        item.setOnClickListener {
//            //use intent
//
//        }
//
//        item2.setOnClickListener {
//            //use intent
//
//        }
//
//        item3.setOnClickListener {
//            //use intent
//
//        }

        popupWindow.isFocusable = true
        popupWindow.width = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.contentView = view

        popupWindow.showAsDropDown(v)
    }
}
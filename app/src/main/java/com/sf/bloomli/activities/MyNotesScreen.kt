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
import com.sf.bloomli.adapters.MyNotesAdapter
import com.sf.bloomli.adapters.QuizFragAdapter
import kotlinx.android.synthetic.main.activity_live_quizzes_screen.*
import kotlinx.android.synthetic.main.activity_my_notes_screen.*
import kotlinx.android.synthetic.main.my_notes_adapter.*

class MyNotesScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_notes_screen)
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
        my_notes_screen_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        my_notes_screen_recycler.adapter = MyNotesAdapter(this)

        //set adapter
        my_notes_screen_recycler2.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        my_notes_screen_recycler2.adapter = MyNotesAdapter(this)

        //set adapter
        my_notes_screen_recycler3.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        my_notes_screen_recycler3.adapter = MyNotesAdapter(this)

        //set adapter
        my_notes_screen_recycler4.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        my_notes_screen_recycler4.adapter = MyNotesAdapter(this)


        //set on click listener
        my_notes_back_icon.setOnClickListener {
            onBackPressed()
        }

        //set on click listener
        creativity_lay.setOnClickListener {
            //visibilities gone and visible
            lay_one_text.visibility=View.VISIBLE
            lay_one_view.visibility=View.VISIBLE
            lay_two_view.visibility=View.GONE
            lay_three_view.visibility=View.GONE
            lay_four_view.visibility=View.GONE
            my_notes_screen_recycler.visibility=View.VISIBLE
            my_notes_screen_recycler2.visibility=View.GONE
            my_notes_screen_recycler3.visibility=View.GONE
            my_notes_screen_recycler4.visibility=View.GONE
            lay_four_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_three_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_one_text.setTextColor(Color.parseColor("#FF000000"))
            lay_two_text.setTextColor(Color.parseColor("#D8D8D8"))
        }

        //set on click listener
        relationship_lay.setOnClickListener {
            //visibilities gone and visible
            lay_one_view.visibility=View.GONE
            lay_two_view.visibility=View.VISIBLE
            lay_three_view.visibility=View.GONE
            lay_four_view.visibility=View.GONE
            my_notes_screen_recycler.visibility=View.GONE
            my_notes_screen_recycler2.visibility=View.VISIBLE
            my_notes_screen_recycler3.visibility=View.GONE
            my_notes_screen_recycler4.visibility=View.GONE
            lay_one_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_two_text.setTextColor(Color.parseColor("#FF000000"))
            lay_four_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_three_text.setTextColor(Color.parseColor("#D8D8D8"))
        }

        //set on click listener
        science_lay.setOnClickListener {
            //visibilities gone and visible
            lay_one_view.visibility=View.GONE
            lay_two_view.visibility=View.GONE
            lay_three_view.visibility=View.VISIBLE
            lay_four_view.visibility=View.GONE
            my_notes_screen_recycler.visibility=View.GONE
            my_notes_screen_recycler2.visibility=View.GONE
            my_notes_screen_recycler3.visibility=View.VISIBLE
            my_notes_screen_recycler4.visibility=View.GONE
            lay_three_text.setTextColor(Color.parseColor("#FF000000"))
            lay_one_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_two_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_four_text.setTextColor(Color.parseColor("#D8D8D8"))

        }

        //set on click listener
        parenting_lay.setOnClickListener {
            //visibilities gone and visible
            lay_one_view.visibility=View.GONE
            lay_two_view.visibility=View.GONE
            lay_three_view.visibility=View.GONE
            lay_four_view.visibility=View.VISIBLE
            my_notes_screen_recycler.visibility=View.GONE
            my_notes_screen_recycler2.visibility=View.GONE
            my_notes_screen_recycler3.visibility=View.GONE
            my_notes_screen_recycler4.visibility=View.VISIBLE
            lay_four_text.setTextColor(Color.parseColor("#FF000000"))
            lay_three_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_one_text.setTextColor(Color.parseColor("#D8D8D8"))
            lay_two_text.setTextColor(Color.parseColor("#D8D8D8"))
        }

    }

    //on bck press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
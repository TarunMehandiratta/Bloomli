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
import com.sf.bloomli.activities.newNote.AddNewNoteActivity
import com.sf.bloomli.adapters.MyNotesAdapter
import com.sf.bloomli.adapters.ViewNotesDetailsAdapter
import com.sf.bloomli.adapters.ViewNotesDetailsAdapterTwo
import kotlinx.android.synthetic.main.activity_my_notes_screen.*
import kotlinx.android.synthetic.main.activity_view_notes_deatils_screen.*

class ViewNotesDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_notes_deatils_screen)
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


        //set adapter
        view_note_details_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        view_note_details_recycler.adapter = ViewNotesDetailsAdapter(this)

        //set adapter
        view_note_details_recycler2.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        view_note_details_recycler2.adapter = ViewNotesDetailsAdapterTwo(this,"")

        //set adapter
        view_note_details_recycler3.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL,false)
        view_note_details_recycler3.adapter = ViewNotesDetailsAdapterTwo(this,"FromConclusion")

        //set on click listener
        intro_lay.setOnClickListener {
            //visibilities gone and visible
            view_note_details_recycler.visibility=View.VISIBLE
            linear_one_view.visibility=View.VISIBLE
            linear_one_view2.visibility=View.INVISIBLE
            linear_one_view3.visibility=View.INVISIBLE
            view_note_details_recycler2.visibility=View.GONE
            view_note_details_recycler3.visibility=View.GONE
            linear_one.setTextColor(Color.parseColor("#FF000000"))
            linear_two.setTextColor(Color.parseColor("#D8D8D8"))
            linear_three.setTextColor(Color.parseColor("#D8D8D8"))
        }

        //set on click listener
        blooms_lay.setOnClickListener {
            //visibilities gone and visible
            view_note_details_recycler2.visibility=View.VISIBLE
            view_note_details_recycler.visibility=View.GONE
            view_note_details_recycler3.visibility=View.GONE
            linear_one_view.visibility=View.INVISIBLE
            linear_one_view2.visibility=View.VISIBLE
            linear_one_view3.visibility=View.INVISIBLE
            linear_one.setTextColor(Color.parseColor("#D8D8D8"))
            linear_two.setTextColor(Color.parseColor("#FF000000"))
            linear_three.setTextColor(Color.parseColor("#D8D8D8"))
        }

        //set on click listener
        conclusion_lay.setOnClickListener {
            //visibilities gone and visible
            view_note_details_recycler3.visibility=View.VISIBLE
            view_note_details_recycler2.visibility=View.GONE
            view_note_details_recycler.visibility=View.GONE
            linear_one_view.visibility=View.INVISIBLE
            linear_one_view2.visibility=View.INVISIBLE
            linear_one_view3.visibility=View.VISIBLE
            linear_one.setTextColor(Color.parseColor("#D8D8D8"))
            linear_two.setTextColor(Color.parseColor("#D8D8D8"))
            linear_three.setTextColor(Color.parseColor("#FF000000"))
        }

        //set on click listener
        pink_outline_lay_plus.setOnClickListener {
            //use intent
            val intent = Intent(this,AddNewNoteActivity::class.java)
            startActivity(intent)
        }

        //set on click listener
        pink_fill_lay_plus.setOnClickListener {
            //use intent
            val intent = Intent(this,CreateNewQuizScreen::class.java)
            startActivity(intent)
        }

        //set on click listener
        view_notes_back_icon.setOnClickListener {
            onBackPressed()
        }

    }
    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
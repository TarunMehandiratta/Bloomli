package com.sf.bloomli.activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.*
import kotlinx.android.synthetic.main.activity_book_of_the_day_description.*


class BookOfTheDayDescriptionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_of_the_day_description)
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
        book_day_back_icon.setOnClickListener {
            //call on back press fun
            onBackPressed()
        }

        //set adapter
        benefits_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        benefits_recycler.adapter = YouMayLikeBenefitsAdapter(this)

        //set similar adapter
        similar_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        similar_recycler.adapter = BookOfTheDaySimilarAdapter(this)

        //set recommended_recycler adapter
        recommended_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        recommended_recycler.adapter = BookOfTheDayRecommendedAdapter(this)

        //set onclick listener
        read_listner_lay.setOnClickListener {
            //use intent
            val intent = Intent(this,BookOfTheDayReadNewScreen::class.java)
            startActivity(intent)
        }

        //set onclick listener
        read_listner_lay2.setOnClickListener {
            //use intent
            val intent = Intent(this,BookOfTheDayListenScreen::class.java)
            startActivity(intent)
        }

        //set on click listener
        benifits_lay_clickable.setOnClickListener {
            //visibilities gone on
            benefits_text.setTextColor(Color.parseColor("#FF000000"))
            idea_text.setTextColor(Color.parseColor("#D8D8D8"))
            about_text.setTextColor(Color.parseColor("#D8D8D8"))
            viewbenifit.visibility=View.VISIBLE
            viewbenifit2.visibility=View.GONE
            viewbenifit3.visibility=View.GONE
            benifit_view.visibility=View.VISIBLE
            idea_view.visibility=View.GONE
            about_view.visibility=View.GONE
        }

        //set on click listener
        idea_lay.setOnClickListener {
            //visibilities gone on
            idea_text.setTextColor(Color.parseColor("#FF000000"))
            benefits_text.setTextColor(Color.parseColor("#D8D8D8"))
            about_text.setTextColor(Color.parseColor("#D8D8D8"))
            viewbenifit2.visibility=View.VISIBLE
            viewbenifit.visibility=View.GONE
            viewbenifit3.visibility=View.GONE
            benifit_view.visibility=View.GONE
            idea_view.visibility=View.VISIBLE
            about_view.visibility=View.GONE

        }

        //set on click listener
        about_lay.setOnClickListener {
            //visibilities gone on
            about_text.setTextColor(Color.parseColor("#FF000000"))
            idea_text.setTextColor(Color.parseColor("#D8D8D8"))
            benefits_text.setTextColor(Color.parseColor("#D8D8D8"))
            viewbenifit3.visibility=View.VISIBLE
            viewbenifit2.visibility=View.GONE
            viewbenifit.visibility=View.GONE
            benifit_view.visibility=View.GONE
            idea_view.visibility=View.GONE
            about_view.visibility=View.VISIBLE

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
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
import kotlinx.android.synthetic.main.activity_book_of_the_day_description.benefits_recycler
import kotlinx.android.synthetic.main.activity_book_of_the_day_description.recommended_recycler
import kotlinx.android.synthetic.main.activity_book_of_the_day_description.similar_recycler
import kotlinx.android.synthetic.main.activity_you_may_like_deatils_screen.*


class YouMayLikeDetailsScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_you_may_like_deatils_screen)
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

    private fun init(){
        read_listner_lay_one.setOnClickListener {
            val intent = Intent(this,BookOfTheDayReadNewScreen::class.java)
            startActivity(intent)
        }

        read_listner_lay2_one.setOnClickListener {
            val intent = Intent(this,BookOfTheDayListenScreen::class.java)
            startActivity(intent)
        }

        //set adapter
        benefits_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        benefits_recycler.adapter = BookOfTheDayBenefitsAdapter(this)

        //set similar adapter
        similar_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        similar_recycler.adapter = YouMayLikeSimilarAdapter(this)

        //set recommended_recycler adapter
        recommended_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        recommended_recycler.adapter = YouMayLikeRecommendedAdapter(this)


        //set on click listener
        you_may_like_back_icon.setOnClickListener {
            onBackPressed()
        }

        //set on click listener
        benifits_lay.setOnClickListener {
            //visibilities gone on
            benefits_text.setTextColor(Color.parseColor("#FF000000"))
            benifit_view.visibility=View.VISIBLE
            benifit_view_.visibility=View.VISIBLE
            idea_text.setTextColor(Color.parseColor("#D8D8D8"))
            idea_view.visibility=View.GONE
            idea_view_.visibility=View.GONE
            about_text.setTextColor(Color.parseColor("#D8D8D8"))
            about_view_.visibility=View.GONE
            about_view_new.visibility=View.GONE

        }

        //set on click listener
        idea_layout.setOnClickListener {
            //visibilities gone on
            benefits_text.setTextColor(Color.parseColor("#D8D8D8"))
            benifit_view.visibility=View.GONE
            benifit_view_.visibility=View.GONE
            idea_text.setTextColor(Color.parseColor("#FF000000"))
            idea_view.visibility=View.VISIBLE
            idea_view_.visibility=View.VISIBLE
            about_text.setTextColor(Color.parseColor("#D8D8D8"))
            about_view_.visibility=View.GONE
            about_view_new.visibility=View.GONE

        }

        //set on click listener
        about_layout.setOnClickListener {
            //visibilities gone on
            benefits_text.setTextColor(Color.parseColor("#D8D8D8"))
            benifit_view.visibility=View.GONE
            benifit_view_.visibility=View.GONE
            idea_text.setTextColor(Color.parseColor("#D8D8D8"))
            idea_view.visibility=View.GONE
            idea_view_.visibility=View.GONE
            about_text.setTextColor(Color.parseColor("#FF000000"))
            about_view_.visibility=View.VISIBLE
            about_view_new.visibility=View.VISIBLE

        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
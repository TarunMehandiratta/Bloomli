package com.sf.bloomli.activities

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.BloomiRecommendationsDetailsAdapter
import com.sf.bloomli.adapters.RecommendedScreenAdapter
import kotlinx.android.synthetic.main.activity_bloomli_recommendation_details_screen.*
import kotlinx.android.synthetic.main.activity_recommend_screen.*
import kotlinx.android.synthetic.main.activity_recommend_screen.recommend_screen_recycler

class BloomliRecommendationDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bloomli_recommendation_details_screen)
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

        //set adapter
        recommendation_details_screen_recycler.layoutManager = GridLayoutManager(this,3)
        recommendation_details_screen_recycler.adapter = BloomiRecommendationsDetailsAdapter(this)

        //set on click listener
        recommend_details_screen_back_icon.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
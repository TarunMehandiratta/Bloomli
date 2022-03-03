package com.sf.bloomli.activities

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.RecommendedScreenAdapter
import com.sf.bloomli.adapters.YouMayLikeAdapter
import kotlinx.android.synthetic.main.activity_recommend_screen.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.you_may_like_recycler

class RecommendScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend_screen)
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


        //get intent
        val getIntent = intent.getStringExtra("tittleName")
        if (getIntent.equals("Best Seller")){
            recommend_screen_tittle_text.setText(getIntent)
        }

        //get intent
        val getIntent2 = intent.getStringExtra("tittleName2")
        if (getIntent2.equals("New Arrivals")){
            recommend_screen_tittle_text.setText(getIntent2)
        }
        //set adapter
        recommend_screen_recycler.layoutManager = GridLayoutManager(this,3)
        recommend_screen_recycler.adapter = RecommendedScreenAdapter(this)

        //set on click listener
        recommend_screen_back_icon.setOnClickListener {
            onBackPressed()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
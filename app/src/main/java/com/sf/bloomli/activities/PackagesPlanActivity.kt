package com.sf.bloomli.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.activity_packages_plan.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class PackagesPlanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packages_plan)

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
        toolbar.tvTitle.setText("Hi John!")
        setClick()


        //set on click listener
        login_btnn_plans.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java) )
            finishAffinity()
        }

        //set on click listener
        icBack.setOnClickListener {
            onBackPressed()
        }
    }

    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setClick() {
        val drawable = middleSection.background as GradientDrawable
        drawable.setStroke(1,ContextCompat.getColor(this,R.color.dark_pink))
    }
}
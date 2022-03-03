package com.sf.bloomli.activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.sf.bloomli.R

import com.sf.bloomli.adapters.SelectedCategoriesSignUpAvatarAdapter

import kotlinx.android.synthetic.main.activity_select_your_quiz_avatar.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class SelectYourQuizAvatarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_your_quiz_avatar)
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

        toolbar.tvTitle.setText(getString(R.string.select_your_quiz_avatar))

        //set adapter
        recycleAvatar.layoutManager = GridLayoutManager(this,2)
        recycleAvatar.adapter = SelectedCategoriesSignUpAvatarAdapter(this)

        toolbar.icBack.setOnClickListener {
            onBackPressed()
        }
        submitBut.setOnClickListener {

            val intent = Intent(this, SelectCategoriesActivity::class.java)
            startActivity(intent)

        }
    }
}
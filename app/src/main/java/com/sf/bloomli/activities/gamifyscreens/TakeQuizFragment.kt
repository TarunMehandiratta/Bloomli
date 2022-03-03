package com.sf.bloomli.activities.gamifyscreens

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sf.bloomli.R
import com.sf.bloomli.adapters.gamesAdapters.CategoryAdapter
import com.sf.bloomli.adapters.gamesAdapters.TakeQuizAdapterTwo
import kotlinx.android.synthetic.main.fragment_take_quiz.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*


class TakeQuizFragment : AppCompatActivity(){
    private var adapter : CategoryAdapter ?= null
    private var adapterTwo : TakeQuizAdapterTwo ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_take_quiz)
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

        setAdapter()
        setAdapterTwo()
        setClick()
    }

    private fun setClick() {
        toolbar.icBack.setOnClickListener {
            onBackPressed()
        }
        toolbar.tvTitle.setTextColor(ContextCompat.getColor(this,R.color.white))
        toolbar.tvTitle.setText(getString(R.string.take_your_quiz))
    }


    private fun setAdapterTwo() {
        adapterTwo = TakeQuizAdapterTwo(this)
        recycleGamification.adapter = adapterTwo

    }

    private fun setAdapter() {
        adapter = CategoryAdapter(this)
        recycleCategory.adapter = adapter
    }

}
package com.sf.bloomli.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.BookOfTheDayBenefitsAdapter
import com.sf.bloomli.adapters.MessageDetailsAdapter
import kotlinx.android.synthetic.main.activity_book_of_the_day_description.*
import kotlinx.android.synthetic.main.activity_message_details_screen.*

class MessageDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_details_screen)
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

        //set adapter
        message_details_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        message_details_recycler.adapter = MessageDetailsAdapter(this)

        //set on click listener
        message_details_back_icon.setOnClickListener {
            //call on back press fun
            onBackPressed()
        }
    }

    ///on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
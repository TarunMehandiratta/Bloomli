package com.sf.bloomli.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sf.bloomli.R
import com.sf.bloomli.adapters.BookOfTheDayListenAdapter
import com.sf.bloomli.adapters.BottomSheetAdapter
import kotlinx.android.synthetic.main.activity_book_of_the_day_listen_screen.*
import kotlinx.android.synthetic.main.activity_book_of_the_day_listen_screen.close_lay2
import kotlinx.android.synthetic.main.activity_book_of_the_day_listen_screen.open_lay
import kotlinx.android.synthetic.main.activity_book_of_the_day_read_new_screen.*
import kotlinx.android.synthetic.main.activity_favourite_categories_deatils_screen.*
import kotlinx.android.synthetic.main.activity_gamify_welcome_screen.*
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.itmes_radio_button.*


class BookOfTheDayListenScreen : AppCompatActivity() {

    lateinit var btnShowBottomSheet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_of_the_day_listen_screen)
        if (Build.VERSION.SDK_INT >= 21) {
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

    private fun init() {

        ///set what others recommend adapter
        listen_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        listen_recycler.adapter =
            BookOfTheDayListenAdapter(this)

        //set onClick Listener listen_screen_back_icon
        listen_screen_back_icon.setOnClickListener {
            onBackPressed()
        }

        //set on click listener
        listen_screen_hint.setOnClickListener {
            //open bottom sheet
            bottomSheet()
        }

        //set on click listener
        close_lay2.setOnClickListener {
            //open lay
            open_lay.visibility=View.VISIBLE
            close_lay2.visibility=View.GONE

        }
        //set on click listener
        open_lay.setOnClickListener {
            //close lay
            close_lay2.visibility=View.VISIBLE
            open_lay.visibility=View.GONE

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    //bottom sheet fun
    @SuppressLint("ResourceType")
    private fun bottomSheet() {

        val dialog = BottomSheetDialog(this,theme.resources.getColor(R.color.whiteTransparent))
        val bottomSheet = layoutInflater.inflate(R.layout.bottom_sheet,null)
        val canclBtn = bottomSheet.findViewById<ImageView>(R.id.top_cancle_icon)
        val recycler = bottomSheet.findViewById<RecyclerView>(R.id.bottom_sheet_recycler)
        dialog.setCancelable(false)
        dialog.setContentView(bottomSheet)
        dialog.window?.setBackgroundDrawableResource(R.color.whiteTransparent)
        canclBtn.setOnClickListener {
            //dismiss btn
            dialog.dismiss()
        }
        //set adapter
        recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        recycler.adapter = BottomSheetAdapter(this)
        dialog.show()

    }
}

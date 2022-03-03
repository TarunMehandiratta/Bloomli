package com.sf.bloomli.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sf.bloomli.R
import com.sf.bloomli.adapters.BottomSheetAdapter
import com.sf.bloomli.adapters.BottomSheetAdapterTwo
import com.sf.bloomli.adapters.ReadBookNewScreenBloomsAdapter
import kotlinx.android.synthetic.main.activity_book_of_the_day_read_new_screen.*

class BookOfTheDayReadNewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_of_the_day_read_new_screen)
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

        ///set adapter
        read_new_book_recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        read_new_book_recycler.adapter = ReadBookNewScreenBloomsAdapter(this)


        //set onclick listener
        read_book_new_back_icon.setOnClickListener {
            onBackPressed()
        }

        //set on click listener
        pink_bulb_img.setOnClickListener {
            //open bottom sheet
            openBottomSheet()
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

    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    ///open bottom sheet fun
    @SuppressLint("ResourceType")
    private fun openBottomSheet() {
        val dialog = BottomSheetDialog(this, theme.resources.getColor(R.color.whiteTransparent))
        val bottomSheet = layoutInflater.inflate(R.layout.bottom_sheet_two, null)
        val canclBtn = bottomSheet.findViewById<ImageView>(R.id.top_cancle_icon)
        val recycler = bottomSheet.findViewById<RecyclerView>(R.id.bottom_sheet_recycler_two)
        dialog.setCancelable(false)
        dialog.setContentView(bottomSheet)
        dialog.window?.setBackgroundDrawableResource(R.color.whiteTransparent)
        canclBtn.setOnClickListener {
            //dismiss btn
            dialog.dismiss()
        }
        //set adapter
        recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recycler.adapter = BottomSheetAdapterTwo(this)
        dialog.show()

    }
}
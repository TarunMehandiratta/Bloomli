package com.sf.bloomli.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.categories_recycler
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_library)
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


    @SuppressLint("ResourceAsColor")
    private fun init(){

        ///set my library screen categories adapter
        my_library_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        my_library_recycler.adapter = MyLibraryAdapter(this)

        ///set my library screen myBooks adapter
//        my_library_book_recycler.layoutManager = GridLayoutManager(context,3)
        my_library_book_recycler.adapter = MyLibraryMyBookAdapter(this)

        ///set my library screen My Wishlist adapter
        my_library_wishlist_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        my_library_wishlist_recycler.adapter = MyLibraryWishlistAdapter(this)

        ///set my library screen My Wishlist adapter
        my_library_recycler_two.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        my_library_recycler_two.adapter = MyLibraryAdapterTwo(this)


             //set onclick listener listenedRecently_Lay
        ReadRecently_Lay.setOnClickListener {
            //visibility Visible on my_library_recycler_two
            text_view_lin_lay_out2.setTextColor(Color.parseColor("#FF000000"))
            ReadRecently_view.visibility = View.VISIBLE
            my_library_recycler_two.visibility = View.VISIBLE

            //visibility Gone on listenedRecently_Lay
            text_view_lin_lay_out.setTextColor(Color.parseColor("#D8D8D8"))
            listenedRecently_view.visibility = View.INVISIBLE
            my_library_recycler.visibility = View.INVISIBLE

        }

        //set onclick listener listenedRecently_Lay
        listenedRecently_Lay.setOnClickListener {
            //visibility Visible on listenedRecently_Lay
            text_view_lin_lay_out.setTextColor(Color.parseColor("#FF000000"))
            listenedRecently_view.visibility = View.VISIBLE
            my_library_recycler.visibility = View.VISIBLE

            //visibility gone on my_library_recycler_two
            text_view_lin_lay_out2.setTextColor(Color.parseColor("#D8D8D8"))
            ReadRecently_view.visibility = View.INVISIBLE
            my_library_recycler_two.visibility = View.INVISIBLE
        }

        three_dots_icon.setOnClickListener {
            onBackPressed()
        }
    }

    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
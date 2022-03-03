package com.sf.bloomli.activities

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.adapters.*
import kotlinx.android.synthetic.main.activity_favourite_categories_deatils_screen.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.categories_recycler

class FavouriteCategoriesDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_categories_deatils_screen)
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

    private fun init(){

        ///set adapter
        fvrt_cate_details_Featured_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        fvrt_cate_details_Featured_recycler.adapter = FavouritesCategoriesDetailsFeaturedAdapter(this)

        ///set adapter
        fvrt_cate_details_last_book_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        fvrt_cate_details_last_book_recycler.adapter = FavouritesCategoriesDetailsLastBookAdapter(this)

        ///set adapter
        fvrt_cate_details_popular_book_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        fvrt_cate_details_popular_book_recycler.adapter = FavouritesCategoriesDetailsPopularBookAdapter(this)

        ///set adapter
        fvrt_cate_details_basics_book_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        fvrt_cate_details_basics_book_recycler.adapter = FavouritesCategoriesDetailsBasicsBookAdapter(this)

        ///set adapter
        fvrt_cate_details_collection_book_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        fvrt_cate_details_collection_book_recycler.adapter = FavouritesCategoriesDetailsCollectionBookAdapter(this)

        ///set adapter
        fvrt_cate_details_classics_book_recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        fvrt_cate_details_classics_book_recycler.adapter = FavouritesCategoriesDetailsClassicsBookAdapter(this)

        //set on click listener
        fvrt_cate_details_back_icon.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
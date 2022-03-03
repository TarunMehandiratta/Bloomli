package com.sf.bloomli.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.activities.*
import com.sf.bloomli.adapters.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.you_may_like_adapter.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){


        ///set favourite categories adapter
        categories_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        categories_recycler.adapter = activity?.let { FavouriteCategoriesAdapter(it) }

        ///set what others recommend adapter
        what_others_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        what_others_recycler.adapter = WhatOthersRecommendAdapter(activity)

        ///set bloomli_recommendations_recycler adapter
        bloomli_recommendations_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        bloomli_recommendations_recycler.adapter = BloomliRecommendationsAdapter(activity)

        //set your_selected_categories_recycler adapter
        your_selected_categories_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        your_selected_categories_recycler.adapter = YourSelectedCategoriesAdapter(activity)

        //set your_selected_categories_recycler adapter
        book_of_day_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        book_of_day_recycler.adapter = BookOfTheDayAdapter(activity)

        //set home_banner_recycler adapter
        home_banner_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        home_banner_recycler.adapter = HomeFragBannerAdapter(activity)
        //set indicator
        three_dots_horizontal.setRecyclerView(home_banner_recycler)



        //set your_selected_categories_recycler adapter
        you_may_like_recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        you_may_like_recycler.adapter = YouMayLikeAdapter(activity)

        //set On click listener
        home_frag_bell.setOnClickListener {
            //use intent
            val intent = Intent(activity, MessagesScreen::class.java)
            startActivity(intent)
        }

        //set on click listener
        recommend_lay.setOnClickListener {
            //use intent
            val intent = Intent(activity,RecommendScreen::class.java)
            startActivity(intent)
        }

        //set on click listener
        bloomli_recommendations_lay.setOnClickListener {
            //use intent
            val intent = Intent(activity,BloomliRecommendationDetailsScreen::class.java)
            startActivity(intent)
        }

        //set on click listener
        selected_cate_lay.setOnClickListener {
            //use intent
            val intent = Intent(activity,SelectedCategoriesDetailsScreen::class.java)
            startActivity(intent)
        }
    }

}
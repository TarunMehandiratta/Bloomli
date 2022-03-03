package com.sf.bloomli.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.activities.RecommendScreen
import com.sf.bloomli.adapters.*
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.categories_recycler

class DiscoverFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        ///set categories adapter
        categories_recycler_discover.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        categories_recycler_discover.adapter = activity?.let { DiscoverCategoriesAdapter(it) }
        dicover_Indicator.setRecyclerView(categories_recycler_discover)

        ///set categories adapter Two
        categories_recycler_discover2.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        categories_recycler_discover2.adapter = activity?.let { DiscoverCategoriesAdapterTwo(it) }

        ///set categories adapter three
        categories_recycler_discover3.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        categories_recycler_discover3.adapter = activity?.let { DiscoverCategoriesAdapterThree(it) }

        ///set categories adapter three
        categories_recycler_discover4.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        categories_recycler_discover4.adapter = DiscoverCategoriesAdapterFour(activity)

        ///set categories adapter three
        recommended_recycler_discover.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        recommended_recycler_discover.adapter = DiscoverRecommendedAdapter(activity)

        ///set categories adapter three
        bestSeller_recycler_discover.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        bestSeller_recycler_discover.adapter = DiscoverBestSellerAdapter(activity)

        ///set categories adapter three
        newArrivals_recycler_discover.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        newArrivals_recycler_discover.adapter = DiscoverNewArrivalsAdapter(activity)

        //set on click listener
        bottom_drawer_lay.setOnClickListener {
            //visibilities gone , visible
            bottom_drawer_lay2.visibility=View.VISIBLE
        }

        //set on click listener
        bottom_text.setOnClickListener {
            //visibilities gone , visible
            bottom_drawer_lay2.visibility=View.GONE
        }

        //set on click listener
        reco_lay.setOnClickListener {
            //use intent
            val intent = Intent(activity, RecommendScreen::class.java)
            startActivity(intent)
        }

        //set on click listener
        best_seller_lay.setOnClickListener {
            //use intent
            val intent = Intent(activity, RecommendScreen::class.java)
            intent.putExtra("tittleName","Best Seller")
            startActivity(intent)
        }

        //set onclick listener
        new_arrivals_lay.setOnClickListener {
            //use intent
            val intent = Intent(activity, RecommendScreen::class.java)
            intent.putExtra("tittleName2","New Arrivals")
            startActivity(intent)
        }
    }

}
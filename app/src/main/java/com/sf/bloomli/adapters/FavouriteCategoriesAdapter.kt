package com.sf.bloomli.adapters

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import com.sf.bloomli.R.*
import com.sf.bloomli.R.drawable.*
import com.sf.bloomli.activities.FavouriteCategoriesDetailsScreen
import kotlinx.android.synthetic.main.discover_categories_adapter.view.*
import kotlinx.android.synthetic.main.list_item_category.view.*
import kotlinx.android.synthetic.main.list_item_category.view.icon

class FavouriteCategoriesAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layout.discover_categories_adapter, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position==0){
            holder.itemView.cate_adapter_text.setText("Mindfulness & hapiness")
        }
        else if (position==1){
            holder.itemView.cate_adapter_text.setText("Religion & Spirituality")
            holder.itemView.icon.setImageResource(R.drawable.star_icon_astro)
        }
        else if (position==2){
            holder.itemView.cate_adapter_text.setText("Sex & Relationships")
            holder.itemView.icon.setImageResource(R.drawable.heart_new)
        }

        if(selectedPosition == position){
            val gradientDrawable = (holder.itemView.mainLayout_discover.getBackground() as GradientDrawable).mutate()
            (gradientDrawable as GradientDrawable).setColor(ContextCompat.getColor(context, color.app_pink))


            val imageCircle = (holder.itemView.icon.getBackground() as GradientDrawable).mutate()
            (imageCircle as GradientDrawable).setColor(ContextCompat.getColor(context, color.white))

            holder.itemView.cate_adapter_text.setTextColor(ContextCompat.getColor(context, color.white))




        }
        else{
            val gradientDrawable = (holder.itemView.mainLayout_discover.getBackground() as GradientDrawable).mutate()
            (gradientDrawable as GradientDrawable).setColor(ContextCompat.getColor(context, color.white))

            val imageCircle = (holder.itemView.icon.getBackground() as GradientDrawable).mutate()
            (imageCircle as GradientDrawable).setColor(ContextCompat.getColor(context, color.app_pink_light))

            holder.itemView.cate_adapter_text.setTextColor(ContextCompat.getColor(context, color.black))



        }


        holder.itemView.mainLayout_discover.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()

        }
        //set on click listener
        holder.itemView.mainLayout_discover.setOnClickListener {
            //use intent
            val intent = Intent(context,FavouriteCategoriesDetailsScreen::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = 3

}
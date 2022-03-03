package com.sf.bloomli.adapters

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.list_item_category.view.*

class SelectedCategoriesSignUpAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(selectedPosition == position){
            val gradientDrawable = (holder.itemView.mainLayout.getBackground() as GradientDrawable).mutate()
            (gradientDrawable as GradientDrawable).setColor(ContextCompat.getColor(context,R.color.app_pink))


            val imageCircle = (holder.itemView.icon.getBackground() as GradientDrawable).mutate()
            (imageCircle as GradientDrawable).setColor(ContextCompat.getColor(context,R.color.white))

            holder.itemView.tv_heading.setTextColor(ContextCompat.getColor(context,R.color.white))


        }
        else{
            val gradientDrawable = (holder.itemView.mainLayout.getBackground() as GradientDrawable).mutate()
            (gradientDrawable as GradientDrawable).setColor(ContextCompat.getColor(context,R.color.white))

            val imageCircle = (holder.itemView.icon.getBackground() as GradientDrawable).mutate()
            (imageCircle as GradientDrawable).setColor(ContextCompat.getColor(context,R.color.app_pink_light))

            holder.itemView.tv_heading.setTextColor(ContextCompat.getColor(context,R.color.black))

        }


           holder.itemView.mainLayout.setOnClickListener {
               selectedPosition = position
               notifyDataSetChanged()

           }
    }

    override fun getItemCount() = 8

}
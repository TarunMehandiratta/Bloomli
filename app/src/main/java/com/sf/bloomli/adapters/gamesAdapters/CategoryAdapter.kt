package com.sf.bloomli.adapters.gamesAdapters

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.itmes_gamify_adapter.view.*
import kotlinx.android.synthetic.main.itmes_radio_button.view.*

class CategoryAdapter (var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itmes_gamify_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(selectedPosition == position){
            holder.itemView.fvt_lay.setBackgroundResource(R.drawable.back_round_gradient_pink_two)
            holder.itemView.tvGamify.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
        else
        {
            holder.itemView.fvt_lay.setBackgroundResource(R.drawable.blackbackground)
            holder.itemView.tvGamify.setTextColor(ContextCompat.getColor(context, R.color.white))
        }

        holder.itemView.fvt_lay.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = 3

}
package com.sf.bloomli.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.items_quiz_adapter.view.*

class QuizFragAdapterTwo(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_quiz_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if(selectedPosition == position){
            holder.itemView.radiobuttonSec.setBackgroundResource(R.drawable.dark_pink_15_radius)
            holder.itemView.randomRadioTwo.setChecked(true)
            holder.itemView.tvRandom.setTextColor(ContextCompat.getColor(context, R.color.black))
            holder.itemView.worldCupTwo.visibility = View.VISIBLE

        }
        else{
            holder.itemView.radiobuttonSec.setBackgroundResource(R.drawable.light_gray_outline_gradient)
            holder.itemView.randomRadioTwo.setChecked(false)
            holder.itemView.tvRandom.setTextColor(ContextCompat.getColor(context, R.color.gray))
            holder.itemView.worldCupTwo.visibility = View.INVISIBLE
        }

        holder.itemView.randomRadioTwo.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = 3

}
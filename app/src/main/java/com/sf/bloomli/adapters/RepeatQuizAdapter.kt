package com.sf.bloomli.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.items_repeat_quiz.view.*

class RepeatQuizAdapter (var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_repeat_quiz_two, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(selectedPosition == position){
            holder.itemView.tvRandom.setBackgroundResource(R.drawable.pink_round_with_20)
            holder.itemView.tvRandom.setTextColor(ContextCompat.getColor(context, R.color.white))
//            holder.itemView.worldCup.visibility = View.VISIBLE
        }
        else{
            holder.itemView.tvRandom.setBackgroundResource(R.drawable.items_pink_border)
            holder.itemView.tvRandom.setTextColor(ContextCompat.getColor(context, R.color.app_pink))

        }

        holder.itemView.tvRandom.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = 3

}
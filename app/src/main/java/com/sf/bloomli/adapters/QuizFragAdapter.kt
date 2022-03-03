package com.sf.bloomli.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.quiz_frag_adapter.view.*

class QuizFragAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var adapter : QuizFragAdapterTwo ?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.quiz_frag_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position==0){
            holder.itemView.quesTwo.visibility=View.GONE
            holder.itemView.q_option_text4.visibility=View.VISIBLE
        }
        else if(position==1){
            holder.itemView.quesTwo.visibility=View.VISIBLE
            holder.itemView.q_option_text4.visibility=View.GONE
        }
        else if(position == 2){
            holder.itemView.quesTwo.visibility=View.GONE
            holder.itemView.q_option_text4.visibility=View.VISIBLE
        }
        else{
            holder.itemView.quesTwo.visibility=View.VISIBLE
            holder.itemView.q_option_text4.visibility=View.GONE
            holder.itemView.worldCupT.setImageResource(R.drawable.sad_smile)
        }

        adapter = QuizFragAdapterTwo(context)
        holder.itemView.q_option_text4.adapter = adapter

    }

    override fun getItemCount() = 4

}
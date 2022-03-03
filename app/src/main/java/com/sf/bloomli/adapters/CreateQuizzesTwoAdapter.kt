package com.sf.bloomli.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.create_quizzes_two_adapter.view.*

class CreateQuizzesTwoAdapter(var context : Context, val listener : EditClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface EditClickListener{
       fun onEditClick(position : Int,type : String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.create_quizzes_two_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.quesOne.setOnClickListener {
            listener.onEditClick(position,"editQues")
        }
        holder.itemView.quesTwo.setOnClickListener {
            listener.onEditClick(position,"editQues")
        }
        holder.itemView.quesMcq.setOnClickListener {
            listener.onEditClick(position,"editMcq")
        }

    }

    override fun getItemCount()= 1
}
package com.sf.bloomli.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.items_quiz_avatar.view.*

class SelectedCategoriesSignUpAvatarAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_quiz_avatar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(selectedPosition == position){
            holder.itemView.borderViewLayout.setBackgroundResource(R.drawable.items_pink_border)
        }
        else{
            holder.itemView.borderViewLayout.setBackgroundResource(0)

        }

        holder.itemView.mainLayout.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()

        }

    }

    override fun getItemCount() = 4

}
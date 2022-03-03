package com.sf.bloomli.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import com.sf.bloomli.listeners.QuestionClick
import kotlinx.android.synthetic.main.items_gamify_mcq.view.*

class QuestionAdapter(var context : Context,val listener : QuestionClick)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var adapter : OptionSelectorAdapterTwo ?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_gamify_mcq, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.mainSec.setOnClickListener {
            listener.onClick(position)
        }

        adapter = OptionSelectorAdapterTwo(context)
        holder.itemView.option_layout.adapter = adapter

    }

    override fun getItemCount() = 2

}
package com.sf.bloomli.adapters.gamesAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import com.sf.bloomli.adapters.OptionSelectorAdapter
import kotlinx.android.synthetic.main.items_existing_ques.view.*
import kotlinx.android.synthetic.main.items_quiz_avatar.view.*

class ExistingQuestionsAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var adapter : OptionSelectorAdapter?= null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_existing_ques, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        adapter = OptionSelectorAdapter(context)
        holder.itemView.recycleOption.adapter = adapter
    }

    override fun getItemCount() = 2

}
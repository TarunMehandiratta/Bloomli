package com.sf.bloomli.adapters

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.view_notes_details_adapter_two.view.*


class ViewNotesDetailsAdapterTwo(var context : Context,var type : String) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var selectedPosition = -1
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_notes_details_adapter_two, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(type.equals("FromConclusion")){
            holder.itemView.bloom_text_view_details.setText(context.getString(R.string.conclusion))
        }
        else{
            holder.itemView.bloom_text_view_details.setText(context.getString(R.string.bloomone))

        }

    }

    override fun getItemCount() = 3

}
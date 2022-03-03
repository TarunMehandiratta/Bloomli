package com.sf.bloomli.adapters.gamesAdapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sf.bloomli.R
import com.sf.bloomli.activities.GamificationQuizScreenActivity
import kotlinx.android.synthetic.main.book_of_the_day_adapter_two.view.*

class TakeQuizAdapterTwo(var context : Context): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.book_of_the_day_adapter_two, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.book_of_the_day_layout.setOnClickListener {
            context.startActivity(Intent(context,GamificationQuizScreenActivity::class.java))
        }


    }

    override fun getItemCount() = 6

}
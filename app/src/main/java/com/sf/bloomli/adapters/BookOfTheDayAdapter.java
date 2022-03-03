package com.sf.bloomli.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sf.bloomli.R;
import com.sf.bloomli.activities.BookOfTheDayDescriptionScreen;

public class BookOfTheDayAdapter extends RecyclerView.Adapter<BookOfTheDayAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public BookOfTheDayAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.book_of_the_day_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //set on click listener whole layout
        holder.book_of_the_day_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use intent
                Intent i = new Intent(activity, BookOfTheDayDescriptionScreen.class);
                activity.startActivity(i);
            }
        });

        //set on click listener listenText
        holder.listenText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use intent
                Intent i = new Intent(activity, BookOfTheDayDescriptionScreen.class);
                activity.startActivity(i);
            }
        });

        //set onClick Listener
        holder.readText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use intent
                Intent i = new Intent(activity, BookOfTheDayDescriptionScreen.class);
                activity.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout book_of_the_day_layout;
        private TextView listenText, readText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            book_of_the_day_layout=itemView.findViewById(R.id.book_of_the_day_layout);
            listenText=itemView.findViewById(R.id.text_book_of_the_day_3);
            readText=itemView.findViewById(R.id.text_book_of_the_day_4);

        }
    }
}

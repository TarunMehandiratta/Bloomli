package com.sf.bloomli.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sf.bloomli.R;
import com.sf.bloomli.activities.CreateQuizzesTwoScreen;
import com.sf.bloomli.activities.LiveQuizzesScreen;

public class MyQuizzesAdapter extends RecyclerView.Adapter<MyQuizzesAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public MyQuizzesAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_quizzes_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        //set on click listener
        holder.cardViewClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use intent
                Intent i = new Intent(activity, LiveQuizzesScreen.class);
                activity.startActivity(i);
            }
        });

        //set onclick listener
        holder.edit_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use intent
                Intent i = new Intent(activity, CreateQuizzesTwoScreen.class);
                activity.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private CardView cardViewClickable;
        private ImageView edit_lay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewClickable=itemView.findViewById(R.id.card_view_lay);
            edit_lay=itemView.findViewById(R.id.edit_lay);

        }
    }
}

package com.sf.bloomli.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sf.bloomli.R;
import com.sf.bloomli.activities.YouMayLikeDetailsScreen;

public class YouMayLikeAdapter extends RecyclerView.Adapter<YouMayLikeAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public YouMayLikeAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.you_may_like_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //set on click listener
        holder.layoutClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use intent
                Intent i = new Intent(activity, YouMayLikeDetailsScreen.class);
                activity.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout layoutClickable;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutClickable=itemView.findViewById(R.id.constraint_lay_clickable_you_may_like);

        }
    }
}

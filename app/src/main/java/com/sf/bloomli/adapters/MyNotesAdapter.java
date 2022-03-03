package com.sf.bloomli.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sf.bloomli.R;
import com.sf.bloomli.activities.ViewNotesDetailsScreen;

public class MyNotesAdapter extends RecyclerView.Adapter<MyNotesAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public MyNotesAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_notes_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //set on click listener
        holder.clickableLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use intent
                Intent i = new Intent(activity, ViewNotesDetailsScreen.class);
                activity.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private RelativeLayout clickableLay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            clickableLay=itemView.findViewById(R.id.view_notes_lay);

        }
    }
}

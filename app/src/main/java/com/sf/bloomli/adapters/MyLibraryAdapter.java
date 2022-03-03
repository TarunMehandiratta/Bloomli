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
import com.sf.bloomli.activities.BookOfTheDayDescriptionScreen;

public class MyLibraryAdapter extends RecyclerView.Adapter<MyLibraryAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public MyLibraryAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_library_read_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.main_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity,BookOfTheDayDescriptionScreen.class);
                activity.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private RelativeLayout main_lay;
    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout main_lay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            main_lay=itemView.findViewById(R.id.main_lay);

        }
    }
}

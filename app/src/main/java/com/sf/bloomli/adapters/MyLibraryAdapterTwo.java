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

public class MyLibraryAdapterTwo extends RecyclerView.Adapter<MyLibraryAdapterTwo.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public MyLibraryAdapterTwo(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_library_read_adapter_two,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.main_lay_my_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use intent
                Intent i = new Intent(activity, BookOfTheDayDescriptionScreen.class);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout main_lay_my_library;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            main_lay_my_library=itemView.findViewById(R.id.main_lay_my_library);
        }
    }
}

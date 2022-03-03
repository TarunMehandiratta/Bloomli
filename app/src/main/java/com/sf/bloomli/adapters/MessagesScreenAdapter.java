package com.sf.bloomli.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sf.bloomli.R;
import com.sf.bloomli.activities.MessageDetailsScreen;

public class MessagesScreenAdapter extends RecyclerView.Adapter<MessagesScreenAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public MessagesScreenAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.messages_screen_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.cardViewLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use intent
                Intent i = new Intent(activity, MessageDetailsScreen.class);
                activity.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private CardView cardViewLay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewLay=itemView.findViewById(R.id.card_view_lay);

        }
    }
}

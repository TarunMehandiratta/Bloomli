package com.sf.bloomli.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sf.bloomli.R;
import com.sf.bloomli.activities.CreateQuizzesTwoScreen;

public class MyQuizAdapter extends RecyclerView.Adapter<MyQuizAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;

    public MyQuizAdapter(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_quiz,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (position==1){
            holder.tittle_text.setText("Summery Quiz");
        }
        else if (position==2){
            holder.tittle_text.setText("Build Confidence");
        }
        holder.my_quizz_lay.setOnClickListener(new View.OnClickListener() {
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


        private TextView tittle_text;
        private RelativeLayout my_quizz_lay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tittle_text=itemView.findViewById(R.id.quiz_tittle);
            my_quizz_lay=itemView.findViewById(R.id.my_quizz_lay);

        }
    }
}

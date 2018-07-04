package com.example.harshnasit.refit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class WorkoutListRecyclerAdapter extends RecyclerView.Adapter<WorkoutListRecyclerAdapter.ViewHolder> {

    private ArrayList<Exercise> exerciseList;
    private Context context;

    WorkoutListRecyclerAdapter(Context context, ArrayList<Exercise> exerciseList){
        this.exerciseList = exerciseList;
        this.context = context;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_workout_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.name.setText(exerciseList.get(position).getName());
        holder.value.setText("0");

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, exerciseList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;
        EditText value;
        RelativeLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            name  = itemView.findViewById(R.id.workout_name);
            value = itemView.findViewById(R.id.workout_value);
            layout = itemView.findViewById(R.id.layout);
        }
    };
}

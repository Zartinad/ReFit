package com.example.harshnasit.refit.WorkoutCreation;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harshnasit.refit.Exercise;
import com.example.harshnasit.refit.R;

import java.util.ArrayList;
import java.util.Collections;

import de.hdodenhof.circleimageview.CircleImageView;

public class WorkoutListRecyclerAdapter extends RecyclerView.Adapter<WorkoutListRecyclerAdapter.ViewHolder> implements RecycleViewAdapter {

    private ArrayList<Exercise> exerciseList;
    private Context context;
    private ItemTouchHelper touchHelper;

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.name.setText(exerciseList.get(position).getName());
        holder.value.setRawInputType(Configuration.KEYBOARD_12KEY);
        holder.handle.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    touchHelper.startDrag(holder);
                }
                return false;
            }


        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Index: " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {

        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemDismiss(int position) {
        exerciseList.remove(position);
        Toast.makeText(context, exerciseList.get(position).getName() + " removed", Toast.LENGTH_SHORT).show();
        notifyItemRemoved(position);
        return true;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;
        EditText value;
        ImageView handle;
        RelativeLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            name  = itemView.findViewById(R.id.workout_name);
            value = itemView.findViewById(R.id.workout_value);
            layout = itemView.findViewById(R.id.layout);
            handle = itemView.findViewById(R.id.handle);
        }

        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }


    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }
}

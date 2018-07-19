package com.example.harshnasit.refit.WorkoutCreation;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import com.example.harshnasit.refit.Exercise;
import com.example.harshnasit.refit.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WorkoutCreation extends AppCompatActivity {

    private ArrayList<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_creation);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        exercises = new ArrayList<>();
        initExercises();
        initRecycleView();
        setDate();
        System.out.println("Working");
    }

    private void initExercises(){
        exercises.add(new Exercise("Bicep Curl"));
        exercises.add(new Exercise("Hammer Curl"));
        exercises.add(new Exercise("Tricep Dips"));
        exercises.add(new Exercise("Bicep Curl"));
        exercises.add(new Exercise("Hammer Curl"));
        exercises.add(new Exercise("Tricep Dips"));
        exercises.add(new Exercise("Bicep Curl"));
        exercises.add(new Exercise("Hammer Curl"));
        exercises.add(new Exercise("Tricep Dips"));
        exercises.add(new Exercise("Bicep Curl"));
        exercises.add(new Exercise("Hammer Curl"));
        exercises.add(new Exercise("Tricep Dips"));
    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        WorkoutListRecyclerAdapter adapter = new WorkoutListRecyclerAdapter(this,this.exercises);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.Callback callback =
                new RecycleViewListItemCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        adapter.setTouchHelper(touchHelper);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void setDate(){
    Date today = Calendar.getInstance().getTime();//getting date
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
    String date = formatter.format(today);
    ((TextView)findViewById(R.id.textViewDate)).setText(date);
    }
}

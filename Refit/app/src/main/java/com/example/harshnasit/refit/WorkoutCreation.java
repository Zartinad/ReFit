package com.example.harshnasit.refit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

        exercises = new ArrayList<>();
    }

    private void initExercises(){
        exercises.add(new Exercise("Bicep Curl"));
        exercises.add(new Exercise("Hammer Curl"));
        exercises.add(new Exercise("Tricep Dips"));


    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        WorkoutListRecyclerAdapter adapter = new WorkoutListRecyclerAdapter(this,this.exercises);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setDate(){


    Date today = Calendar.getInstance().getTime();//getting date
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
    String date = formatter.format(today);
    ((TextView)findViewById(R.id.textViewDate)).setText(date);

    }
}

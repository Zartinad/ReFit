package com.example.harshnasit.refit;

import java.util.ArrayList;

public class Workout {
    private ArrayList<Exercise> exercises; // The exercises.

    /** Add an exercise to this workout if its not in it.
     * @param exercise The exercise to be added.
     */
    void addExercise(Exercise exercise){
        if(!exercises.contains(exercise)) {
            exercises.add(exercise);
        }
    }

    void removeExercise(Exercise exercise){
        if(exercises.contains(exercise)){
            exercises.remove(exercise);
        }
    }
}

package model;

import java.util.ArrayList;

public class WorkoutList {
    
    private ArrayList<Workout> workoutList;
                      
    public WorkoutList() {
        workoutList = new ArrayList<>();
    }

    // REQUIRES: workout cannot be null
    // MODIFIES: workoutList
    // EFFECTS: adds created exercise to WorkoutList
    public void addWorkout(Workout workout) {
        workoutList.add(workout);
    }

    public ArrayList<Workout> getWorkoutList() {
        return workoutList;
    }

    
}

package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

//This class represents a list of workouts
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

    //EFFECTS: returns the WorkoutList
    public ArrayList<Workout> getWorkoutList() {
        return workoutList;
    }

    public int size() {
        return workoutList.size();
    }

    public boolean contains(Workout workout) {
        return workoutList.contains(workout);
    }

    //REQUIRES: workoutList can't be null
    //EFFECTS: returns json object of workoutList
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        for(Workout w : workoutList) {
            array.put(w.toJson());
        }
        obj.put("WorkoutList", array);
        return obj;
    }
}

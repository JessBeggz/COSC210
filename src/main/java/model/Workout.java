package model;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

// This class creates a new workout for the user to add exercises too
public class Workout {
    private String name;
    private ArrayList<Exercise> workoutExercises;

    // Default Constructor
    public Workout() {
        name = "Unnamed Workout";
        workoutExercises = new ArrayList<>();
    }

    public Workout(String name) {
        this.name = name;
        workoutExercises = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // REQUIRES: this, workoutList, exerciseList  cannot be null
    // MODIFIES: this, workoutList, exerciseList
    public ArrayList<Exercise> getWorkoutExercises() {
        return workoutExercises;
    }
    // EFFECTS: returns an int representing the size of the list
    public int size(){
        return workoutExercises.size();
    }

    // REQUIRES: e cannot be null
    // MODIFIES: workoutExercises
    // EFFECTS: checks if an exercise with the same name is already in workoutExercises. Adds to workoutExercises if there is not an exercise with the same name
    public void addExercise(Exercise e) {
        for(Exercise exercise : workoutExercises) {
            if(e.getName().equals(exercise.getName())) {
                System.out.println(e.getName() + " not added to workout. Cannot add duplicate exercises.");
                return;
            }
        }
        workoutExercises.add(e);
    }
    

    //REQUIRES: workoutExercises can't be null
    //EFFECTS: returns json object representing this workout
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < workoutExercises.size(); i++) {
            JSONObject workouts = new JSONObject();
            workouts.put("name", workoutExercises.get(i).getName());
            workouts.put("reps", workoutExercises.get(i).getReps());
            workouts.put("sets", workoutExercises.get(i).getSets());
            workouts.put("weight", workoutExercises.get(i).getWeight());
            array.put(workouts);
            }
            obj.put("workoutTitle", this.getName());
            obj.put("WorkoutExercises", array);
            return obj;
    }
}

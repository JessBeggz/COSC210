package model;
import java.util.*;

// This class creates a new workout for the user to add exercises too
public class Workout {
    Scanner scanner = new Scanner(System.in);

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
        // System.out.println(e.getName() + " added to workout.");
    }
}

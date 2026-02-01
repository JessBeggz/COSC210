package model;

import java.util.Scanner;

// This class creates a new workout with a unique name
public class Workout {
    Scanner scanner = new Scanner(System.in);

    private String name;

    // Default Constructor
    public Workout() {
        name = "Unnamed Workout";
    }

    public Workout(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // REQUIRES: workout, workoutList, exerciseList, userExerciseList cannot be null
    // MODIFIES: workout, workoutList, exerciseList, userExerciseList
    // EFFECTS: This is the user dashboard for creating a workout
    public void start(Workout workout, WorkoutList workoutList, ExerciseList exerciseList) {
        boolean workoutRun = true;
        while(workoutRun) {
            System.out.println("Type 1 to add an exercise");
            System.out.println("Type 2 to view completed exercises");
            System.out.println("Type 3 to complete workout");
            int userSelection = scanner.nextInt();
            if(userSelection == 1) {
                
            } else if(userSelection == 3) {
                workoutRun = false;
                markComplete(workout, workoutList);
            }
        }
       
    }
    //Requires: workout, workoutList cannot be null
    //Modifies: workoutList
    //Effects: Add current workout to workoutList, exit workout and go back to home dashboard
    public void markComplete(Workout workout, WorkoutList workoutList) {
        System.out.println(workout.getName() + " Complete!");
        workoutList.addWorkout(workout);
    }

    public void createWorkout(Workout workout, WorkoutList workoutList, ExerciseList exerciseList) {
        System.out.println("Name workout: ");
        String workoutName = scanner.nextLine();
            if(workoutName.length() > 0) {
                workout.setName(workoutName);
            }
            start(workout, workoutList, exerciseList);
    }

}

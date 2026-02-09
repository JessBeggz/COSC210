package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkoutList implements Saveable, Loadable{
    
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

    @Override
    public void save() {
        FileWriter file;
        try {
            file = new FileWriter("WorkoutListSave.txt");

            for(Workout workout : workoutList) {
                file.write(workout.getName() + "\n");
                for (int i = 0; i < workout.getWorkoutExercises().size(); i++) {
                file.write(workout.getWorkoutExercises().get(i).getName() + "\n");
                file.write(workout.getWorkoutExercises().get(i).getReps() + "\n");
                file.write(workout.getWorkoutExercises().get(i).getSets() + "\n");
                file.write(workout.getWorkoutExercises().get(i).getWeight() + "\n");
                file.write("\n");
            }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void load() {
        File file;
        try {
            file = new File("WorkoutListSave.txt");
            Scanner in = new Scanner(file);
            
            while(in.hasNextLine()) {
                String workoutName = in.nextLine();
                Workout workout = new Workout(workoutName);
                if (!in.nextLine().equals("")) {
                    String exerciseName = in.nextLine();
                    int exerciseReps = in.nextInt();
                    int exerciseSets = in.nextInt();
                    int exerciseWeight = in.nextInt();
                    Exercise exercise = new Exercise(exerciseName, exerciseReps, exerciseSets, exerciseWeight);
                    workout.addExercise(exercise);
                }
                addWorkout(workout);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

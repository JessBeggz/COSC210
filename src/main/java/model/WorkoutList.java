package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class WorkoutList implements Saveable, Loadable {

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
    //MODIFES: workoutListData.json
    //EFFECTS: Converts and saves workoutlist to json
    @Override
    public void save() {
        JSONObject root = new JSONObject();
        JSONArray saveArray = new JSONArray();
        FileWriter file;
        for (Workout workout : workoutList) {
            JSONObject exercises = new JSONObject();
            JSONArray exercisesArray = new JSONArray();
            for (int i = 0; i < workout.getWorkoutExercises().size(); i++) {
                JSONObject workouts = new JSONObject();
                workouts.put("name", workout.getWorkoutExercises().get(i).getName());
                workouts.put("reps", workout.getWorkoutExercises().get(i).getReps());
                workouts.put("sets", workout.getWorkoutExercises().get(i).getSets());
                workouts.put("weight", workout.getWorkoutExercises().get(i).getWeight());
                exercisesArray.put(workouts);
            }
            exercises.put("title", workout.getName());
            exercises.put("exercises", exercisesArray);
            saveArray.put(exercises);
        }
        root.put("workoutList", saveArray);
        try {
            System.out.println(root.toString(2)); //FOR EXAMPLE
            file = new FileWriter("./data/workoutListData.json");
            file.write(root.toString());
            file.close();
            System.out.println("Saved WorkoutList!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // FileWriter file;
        // try {
        //     file = new FileWriter("WorkoutListSave.txt");
        //     for(Workout workout : workoutList) {
        //         file.write(workout.getName() + "\n");
        //         for (int i = 0; i < workout.getWorkoutExercises().size(); i++) {
        //         file.write(workout.getWorkoutExercises().get(i).getName() + "\n");
        //         file.write(workout.getWorkoutExercises().get(i).getReps() + "\n");
        //         file.write(workout.getWorkoutExercises().get(i).getSets() + "\n");
        //         file.write(workout.getWorkoutExercises().get(i).getWeight() + "\n");
        //     }
        //     file.write("end \n");
        //     }
        // file.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    @Override
    public void load() {
        File file;
        try {
            file = new File("WorkoutListSave.txt");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String workoutName = in.nextLine();
                Workout workout = new Workout(workoutName);
                String checkLine;
                while (!(checkLine = in.nextLine()).equals("end ")) {
                    String exerciseName = checkLine;
                    int exerciseReps = Integer.parseInt(in.nextLine());
                    int exerciseSets = Integer.parseInt(in.nextLine());
                    int exerciseWeight = Integer.parseInt(in.nextLine());
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

package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
//This class represents a list of exercise objects

public class ExerciseList implements Saveable, Loadable {

    Scanner scanner = new Scanner(System.in);

    private ArrayList<Exercise> list;
    private Exercise squat = new Exercise("Squat");
    private Exercise hipThrust = new Exercise("Hip Thrust");
    private Exercise benchPress = new Exercise("Bench Press");
    private Exercise legPress = new Exercise("Leg Press");
    private Exercise bicepCurls = new Exercise("Bicep Curls");
    private Exercise legCurls = new Exercise("Leg Curls");
    private Exercise latPulldown = new Exercise("Lat Pulldown");

    public ExerciseList() {
        list = new ArrayList<>();
        list.add(squat);
        list.add(hipThrust);
        list.add(benchPress);
        list.add(legPress);
        list.add(bicepCurls);
        list.add(legCurls);
        list.add(latPulldown);
    }

    // EFFECTS: returns the list within ExerciseList object
    public ArrayList<Exercise> getExerciseList() {
        return list;
    }

    // REQUIRES: e cannot be null
    // MODIFIES: this
    // EFFECTS: sets this ExerciseList to e
    public void setExerciseList(ArrayList<Exercise> e) {
        this.list = e;
    }

    // REQUIRES: e cannot be null
    // MODIFIES: this
    // EFFECTS: if the list does not already contain the exercise name that is wanted to be added, then add the exercise to the list
    public void add(Exercise e) {
        boolean exists = false;

        for (Exercise exercise : list) {
            if (e.getName().equals(exercise.getName())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            list.add(e);
        }
    }

    // REQUIRES: e cannot be null
    // MODIFIES: this
    // EFFECTS: if the list contains the exercise that is wanted to be removed, then remove the exercise from the list
    public void remove(Exercise e) {
        if (list.contains(e)) {
            list.remove(e);
        }
    }

    // REQUIRES: e cannot be null
    // EFFECTS: returns a boolean. true if list contains the exercise and false if the list does not contain the exercise
    public boolean contains(Exercise e) {
        return list.contains(e);
    }

    // EFFECTS: returns an int representing the size of the list
    public int size() {
        return list.size();
    }

    @Override
    public void save() {
        JSONObject root = new JSONObject();
        JSONArray saveArray = new JSONArray();
        FileWriter file;
        for (Exercise exercise : list) {
            JSONObject exerciseName = new JSONObject();
            exerciseName.put("name", exercise.getName());
            saveArray.put(exerciseName);
        }
        root.put("exerciseList", saveArray);
        try {
            System.out.println(root.toString(2)); // FOR EXAMPLE
            file = new FileWriter("./data/exerciseListData.json");
            file.write(root.toString());
            file.close();
            System.out.println("Saved ExerciseList!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // FileWriter file;
        // try {
        //     file = new FileWriter("ExerciseListSave.txt");
        //     for(Exercise myList : list) {
        //         file.write(myList.getName() + "\n");
        //     }
        //     file.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    @Override
    public void load() {
        File file;
        try {
            file = new File("ExerciseListSave.txt");
            Scanner in = new Scanner(file);

            while (in.hasNext()) {
                String exerciseName = in.nextLine();
                Exercise exercise = new Exercise(exerciseName);
                add(exercise);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

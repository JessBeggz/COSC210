package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

// this class represents a list of exercises
public class ExerciseList {

    private ArrayList<Exercise> list;
    // default exercises
    private WeightedExercise squat = new WeightedExercise("Squat");
    private WeightedExercise hipThrust = new WeightedExercise("Hip Thrust");
    private WeightedExercise benchPress = new WeightedExercise("Bench Press");
    private WeightedExercise legPress = new WeightedExercise("Leg Press");
    private WeightedExercise bicepCurls = new WeightedExercise("Bicep Curls");
    private WeightedExercise legCurls = new WeightedExercise("Leg Curls");
    private WeightedExercise latPulldown = new WeightedExercise("Lat Pulldown");
    private CardioExercise run = new CardioExercise("Run", 0, 0);

    public ExerciseList() {
        list = new ArrayList<>();
        list.add(squat);
        list.add(hipThrust);
        list.add(benchPress);
        list.add(legPress);
        list.add(bicepCurls);
        list.add(legCurls);
        list.add(latPulldown);
        list.add(run);
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
    // EFFECTS: if the list contains the exercise that is wanted to be removed, and the exercise is not a default exercise,
    // then remove the exercise from the list
    public void removeExercise(String e) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(e)) {
                String name = list.get(i).getName();
            
                if (name.equals("Squat")||name.equals("Hip Thrust")||
                name.equals("Bench Press")||name.equals("Leg Press")||
                name.equals("Bicep Curls")||name.equals("Leg Curls")||
                name.equals("Lat Pulldown")) {
                    System.out.println("This exercise cannot be removed as it is a default exercise. \n");
                    System.out.println("Returning to Home Page ... \n");
                } else {
                    list.remove(i);
                    System.out.println("Exercise successfully removed! \n");
                }
                return;
            }
        }
        System.out.println("No exercise found with that name.");
        System.out.println("Returning to Home Page ... \n");
    }

    // REQUIRES: e cannot be null
    // EFFECTS: returns a boolean. true if list contains the exercise and false if the list does not contain the exercise
    public boolean contains(WeightedExercise e) {
        return list.contains(e);
    }

    // EFFECTS: returns an int representing the size of the list
    public int size() {
        return list.size();
    }

    //REQUIRES: list can't be null
    //EFFECTS: returns json object representing this exerciseList
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray cardioArray = new JSONArray();
        for(Exercise e : list) {
            if(e instanceof WeightedExercise) {
                array.put(e.toJson());
            }
        }
        obj.put("exerciseList", array);

        for(Exercise c : list) {
            if(c instanceof CardioExercise) {
                cardioArray.put(c.toJson());
            }
        }
        obj.put("cardioExerciseList", cardioArray);

        
        return obj;
    }
}

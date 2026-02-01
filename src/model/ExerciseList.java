package model;
import java.util.*;
//This class represents an Exercise List
public class ExerciseList {
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

    public ArrayList<Exercise> getExerciseList() {
        return list;
    }

    // REQUIRES: e cannot be null
    // MODIFIES: this
    // EFFECTS: If the list does not already contain the exercise name that is wanted to be added, then add the exercise to the list
    public void add(Exercise e) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!e.getName().equals(list.get(i).getName()))
                count++;
            if (count==list.size())
                list.add(e);
        }
    }

    // REQUIRES: e cannot be null
    // MODIFIES: this
    // EFFECTS: If the list contains the exercise that is wanted to be removed, then remove the exercise from the list
    public void remove(Exercise e) {
        if (list.contains(e))
            list.remove(e);
    }

    // REQUIRES: e cannot be null
    // EFFECTS: returns a boolean. true if list contains the exercise and false if the list does not contain the exercise
    public boolean contains(Exercise e) {
        return list.contains(e);
    }

    // EFFECTS: returns an int representing the size of the list
    public int size(){
        return list.size();
    }

    // EFFECTS: Prints the names of the exercises in the list
    public void view(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    public void createExercise() {
        System.out.println("Exercise name: ");
        String name = scanner.nextLine();
        Exercise exercise = new Exercise(name);
        list.add(exercise);
    }
}

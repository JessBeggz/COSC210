package model;
import java.util.*;
//This class represents an Exercise List
public class ExerciseList {
    private ArrayList<Exercise> list;

    public ExerciseList() {
        list = new ArrayList<>();
    }

    // REQUIRES: e cannot be null
    // MODIFIES: this
    // EFFECTS: If the list does not already contain the exercise that is wanted to be added, then add the exercise to the list
    public void add(Exercise e) {
        if (!list.contains(e))
            list.add(e);
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
}

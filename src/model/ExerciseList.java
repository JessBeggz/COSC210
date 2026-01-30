package model;
import java.util.*;
//This class represents an Exercise List
public class ExerciseList {
    private ArrayList<Exercise> list;

    public ExerciseList() {
        list = new ArrayList<>();
    }

    public void add(Exercise e) {
        list.add(e);
    }

    public void remove(Exercise e) {
        list.remove(e);
    }

    public boolean contains(Exercise e) {
        return list.contains(e);
    }

    public int size(){
        return list.size();
    }
}

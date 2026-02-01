package model;

import java.util.ArrayList;

public class UserExerciseList {
    private ArrayList<Exercise> list;

    public UserExerciseList() {
        list = new ArrayList<>();
    }

    // REQUIRES: name cannot be null
    // MODIFIES: UserExerciseList
    // EFFECTS: adds created exercise to UserExerciseList
    public void createExercise(String name) {
        Exercise exercise = new Exercise(name);
        list.add(exercise);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: view current UserExerciseList
    public void view(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}

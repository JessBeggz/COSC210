package UI;

import java.util.Scanner;
import model.Exercise;
import model.ExerciseList;

public class ExerciseManager {
    Scanner scanner = new Scanner(System.in);
     

    // REQUIRES: exerciseList cannot be null
    // MODIFIES: exerciseList
    // EFFECTS: takes user inputted name and adds to the list of available exercises
    public void createExercise(ExerciseList exerciseList) {
        System.out.println("Exercise name: ");
        String name = scanner.nextLine();
        Exercise exercise = new Exercise(name);
        exerciseList.add(exercise);
    }   

}

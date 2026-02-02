package UI;

// This class represents the UI for managing exericses, this means this is the user interface for creating an exercise, viewing the exercise list etc.
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
        for(Exercise exercise : exerciseList.getExerciseList()) {
            if(exercise.getName().equalsIgnoreCase(name)) {
                System.out.println("Exercise already exisits");
                return;
            }
        }
        Exercise exercise = new Exercise(name);
        exerciseList.add(exercise);
    }   

        // EFFECTS: prints the names of the exercises in the list in the terminal
    public void view(ExerciseList exerciseList){
        for (int i = 0; i < exerciseList.size(); i++) {
            System.out.println(exerciseList.getExerciseList().get(i).getName());
        }
    }

}

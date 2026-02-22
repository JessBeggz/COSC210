package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Exercise;
import model.ExerciseList;

// This class represents the UI for managing exericses, this means this is the user interface for creating an exercise, viewing the exercise list etc.
public class ExerciseManager {
    Scanner scanner = new Scanner(System.in);

    // REQUIRES: exerciseList cannot be null
    // MODIFIES: exerciseList
    // EFFECTS: takes user input to create exercise name and adds to the list of available exercises if the exercise name doesn't already exist
    public void createExercise(ExerciseList exerciseList) {
        System.out.println("Exercise name: ");
        String name = scanner.nextLine();
        for(Exercise exercise : exerciseList.getExerciseList()) {
            if(exercise.getName().equalsIgnoreCase(name)) {
                System.out.println("Exercise already exists.");
                return;
            }
        }
        Exercise exercise = new Exercise(name);
        exerciseList.add(exercise);
    }

    // REQUIRES: e cannot be null
    // MODIFIES: exerciseList
    // EFFECTS: if the list contains the exercise that is wanted to be removed, and the exercise is not a default exercise,
    // then remove the exercise from the list
    public void removeExercise(ExerciseList exerciseList) {
        System.out.println("Enter the name of the exercise that you wish to remove: ");
        String exerciseName = scanner.nextLine();
        exerciseList.removeExercise(exerciseName);
    }

    // REQUIRES: exerciseList cannot be null
    // EFFECTS: prints the names of the exercises in the list in the terminal
    public void view(ExerciseList exerciseList) throws InputMismatchException {
        System.out.println("--------------");
        for (int i = 0; i < exerciseList.size(); i++) {
            System.out.println((i + 1) + ". " + exerciseList.getExerciseList().get(i).getName());
        }
        System.out.println("--------------");
        System.out.println("Do you wish to remove an exercise from the list? (Y/N)");
        String userSelection;
        boolean valid = false;
        while (!valid) {
        try {
            userSelection = scanner.nextLine();
            if (userSelection.equalsIgnoreCase("Y")) {
                removeExercise(exerciseList);
                valid = true;
            } else if (userSelection.equalsIgnoreCase("N")) {
                System.out.println("Returning to Home Page ... \n");
                valid = true;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid response (Y/N)");
            scanner.next();
        }
        }
    }

    // REQUIRES: exerciseList cannot be null
    // EFFECTS: prints the names of the exercises in the list in the terminal
    public void viewOnly(ExerciseList exerciseList) {
        System.out.println("--------------");
        for (int i = 0; i < exerciseList.size(); i++) {
            System.out.println((i + 1) + ". " + exerciseList.getExerciseList().get(i).getName());
        }
        System.out.println("--------------");
    }
}

package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.ExerciseList;
import model.WorkoutList;

public class SavePrompt {

    public boolean exitApp(WorkoutList workoutList, ExerciseList exerciseList) {
        Scanner scanner = new Scanner(System.in);
        boolean validChoice = false;
        int userSelection;
        System.out.println("Type '1' to save and exit");
        System.out.println("Type '2' to exit without saving");
        System.out.println("Type '3' to cancel");
        while(!validChoice) {
            try {
                userSelection = scanner.nextInt();
                switch(userSelection) {
                    case 1: workoutList.save(); exerciseList.save(); return false;
                    case 2: return false;
                    case 3: return true;
                    default: System.out.println("Invalid choice, please enter a valid integer (1-3)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer (1-3)");
                scanner.nextLine();
            }
        }
        return true;
    }
}

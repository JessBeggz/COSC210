package UI;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ExerciseList;
import model.WorkoutList;
import persistence.JsonWriter;

// This class represents the UI for a save prompt that is shown to the user when they exit the app
public class SavePrompt {

    //REQUIRES: workoutList and exerciseList can't be null
    //MODIFIES: workoutList, exerciseList
    //EFFECTS: Gives user option to save and exit, don't save and exit, or cancel
    public boolean exitApp(WorkoutList workoutList, ExerciseList exerciseList) {
        JsonWriter exerciseWriter = new JsonWriter("./data/exerciseListData.json");
        JsonWriter workoutWriter = new JsonWriter("./data/workoutListData.json");
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
                    case 1: exerciseWriter.open(); exerciseWriter.write(exerciseList); exerciseWriter.closeWriter(); workoutWriter.open(); workoutWriter.write(workoutList); workoutWriter.closeWriter(); return false;
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

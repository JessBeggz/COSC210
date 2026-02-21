package UI;
// This class is the UI for our home dashboard of our workout app.
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ExerciseList;
import model.Workout;
import model.WorkoutList;
import persistence.JsonReader;

public class HomePage {
    public static void startApp() {
        WorkoutList workoutList;
        ExerciseList exerciseList;
        WorkoutPage workoutPage = new WorkoutPage();
        ExerciseManager exerciseManager = new ExerciseManager();
        SavePrompt savePrompt = new SavePrompt();

        try {
            JsonReader workoutListReader = new JsonReader("./data/workoutListData.json");
            workoutList = workoutListReader.readWorkoutList();

            JsonReader exerciseListReader = new JsonReader("./data/exerciseListData.json");
            exerciseList = exerciseListReader.readExerciseList();
            System.out.println("Previous data found! Loading data ...");
        } catch (IOException e) {
            workoutList = new WorkoutList();
            exerciseList = new ExerciseList();
            System.out.println("No previous data found. Starting with default Exercise List.");
        }
    
        selection(workoutList, exerciseList, workoutPage, exerciseManager, savePrompt);
        // Scanner scanner = new Scanner(System.in);
        // boolean homePageRun = true;
        // while(homePageRun) {
        //     System.out.println("Type '1' to begin new workout");
        //     System.out.println("Type '2' to view workout history");
        //     System.out.println("Type '3' to create an exercise");
        //     System.out.println("Type '4' to view Exercise List");
        //     System.out.println("Type '5' to exit");
        //     int userSelection;
        //     boolean validChoice = false;
        //     while(!validChoice) {
        //         try {
        //     userSelection = scanner.nextInt();
        //     switch(userSelection) {
        //     case 1: Workout workout = new Workout(); workoutPage.createWorkout(workout, workoutList, exerciseList); break;
        //     case 2: workoutPage.viewWorkoutList(workoutList); break;
        //     case 3: exerciseManager.createExercise(exerciseList); break;
        //     case 4: exerciseManager.view(exerciseList); break;
        //     case 5: homePageRun = savePrompt.exitApp(workoutList, exerciseList);
        //     }
        //     validChoice = true;
        //     } catch (InputMismatchException e) {
        //         System.out.println("Please enter a valid integer (1-5)");
        //         scanner.nextLine();
        //     }
        //     }
        // }
        // scanner.close();
    }
    public static void selection(WorkoutList workoutList, ExerciseList exerciseList, WorkoutPage workoutPage, ExerciseManager exerciseManager, SavePrompt savePrompt) {
        Scanner scanner = new Scanner(System.in);
        boolean homePageRun = true;
        while(homePageRun) {
            System.out.println("Type '1' to begin new workout");
            System.out.println("Type '2' to view workout history");
            System.out.println("Type '3' to create an exercise");
            System.out.println("Type '4' to view Exercise List");
            System.out.println("Type '5' to exit");
            int userSelection;
            boolean validChoice = false;
            while(!validChoice) {
                try {
                    userSelection = scanner.nextInt();
                    switch(userSelection) {
                    case 1: Workout workout = new Workout(); workoutPage.createWorkout(workout, workoutList, exerciseList); break;
                    case 2: workoutPage.viewWorkoutList(workoutList); break;
                    case 3: exerciseManager.createExercise(exerciseList); break;
                    case 4: exerciseManager.view(exerciseList); break;
                    case 5: homePageRun = savePrompt.exitApp(workoutList, exerciseList);
                    }
                    validChoice = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer (1-5)");
                scanner.nextLine();
            }
            }
        }
        scanner.close();
    }
}

package UI;
// This class is the UI for our home dashboard of our workout app.
import java.util.InputMismatchException;
import java.util.Scanner;
import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

public class HomePage {
    public static void startApp(WorkoutList workoutList, ExerciseList exerciseList) {
        WorkoutPage workoutPage = new WorkoutPage();
        ExerciseManager exerciseManager = new ExerciseManager();
        exerciseList.load();
        workoutList.load();
    
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
            case 5: exerciseList.save(); workoutList.save(); homePageRun = false;
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

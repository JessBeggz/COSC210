package UI;

import java.util.Scanner;
import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

public class HomePage {
    public static void startApp(WorkoutList workoutList, ExerciseList exerciseList) {
         WorkoutPage workoutPage = new WorkoutPage();
         ExerciseManager exerciseManager = new ExerciseManager();
        Scanner scanner = new Scanner(System.in);
        boolean homePageRun = true;
        while(homePageRun) {
            System.out.println("Type '1' to begin new workout");
            System.out.println("Type '2' to view workout history");
            System.out.println("Type '3' to create an exercise");
            int userSelection = scanner.nextInt();

        switch(userSelection) {
            case 1:Workout workout = new Workout();
                 workoutPage.createWorkout(workout, workoutList, exerciseList);
                 break;
            case 2:
            workoutPage.viewWorkoutList(workoutList);
            break;
            case 3:
                 exerciseManager.createExercise(exerciseList);
                 break;
        }
        }
        scanner.close();
    }
}

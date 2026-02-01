package model;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WorkoutList workoutList = new WorkoutList();
        ExerciseList exerciseList = new ExerciseList();
        startApp(workoutList, exerciseList);
    }
    
    public static void startApp(WorkoutList workoutList, ExerciseList exerciseList) {
        Scanner scanner = new Scanner(System.in);
        boolean homePageRun = true;
        while(homePageRun) {
            System.out.println("Type '1' to begin new workout");
            System.out.println("Type '2' to view workout history");
            System.out.println("Type '3' to view Exercise List");
            System.out.println("Type '4' to create an exercise");
            int userSelection = scanner.nextInt();

        switch(userSelection) {
            case 1:Workout workout = new Workout();
                workout.createWorkout(workout, workoutList, exerciseList); break;
            case 2: workoutList.viewWorkoutList(); break;
            case 3: exerciseList.view(); break;
            case 4: exerciseList.createExercise(); break;
        }
        }
        scanner.close();
    }

}

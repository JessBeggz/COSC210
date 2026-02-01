package model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WorkoutList workoutList = new WorkoutList();
        ExerciseList exerciseList = new ExerciseList();
        UserExerciseList userExerciseList = new UserExerciseList();
        startApp(workoutList, exerciseList, userExerciseList);
    }

    public static void startApp(WorkoutList workoutList, ExerciseList exerciseList, UserExerciseList userExerciseList) {
        Scanner scanner = new Scanner(System.in);
        boolean homePageRun = true;
        while(homePageRun) {
            System.out.println("Type '1' to begin new workout");
            System.out.println("Type '3 to add exercise");
            System.out.println("Type '2' to view workout history");
            int userSelection = scanner.nextInt();
            if(userSelection == 1) {
                Workout newWorkout;
                System.out.println("Name workout: ");
                scanner.nextLine();
                String workoutName = scanner.nextLine();
                if(workoutName.length() > 0) {
                    newWorkout = new Workout(workoutName);
                } else {
                    newWorkout = new Workout();
                }
                newWorkout.start(newWorkout, workoutList, exerciseList, userExerciseList);
        } else if(userSelection == 2) {
            workoutList.viewWorkoutList();
        }
        }
        scanner.close();
    }

}

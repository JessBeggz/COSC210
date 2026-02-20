package UI;
// This class represents the home dashboard UI for the user when they begin a workout

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Exercise;
import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

public class WorkoutPage {

    Scanner scanner = new Scanner(System.in);

    // REQUIRES: workout, workoutList and exerciseList cannot be null
    // MODIFIES: workout, workoutList and exerciseList
    // EFFECTS: This is the user dashboard for creating a workout
    public void start(Workout workout, WorkoutList workoutList, ExerciseList exerciseList) {
        boolean workoutRun = true;
        int userSelection = 0;
        while (workoutRun) {
            System.out.println("Type '1' to choose an exercise");
            System.out.println("Type '2' to complete workout");

            boolean validChoice = false;
            while (!validChoice) {
                try {
                    userSelection = scanner.nextInt();

                    validChoice = true;
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid integer (1-2)");
                    scanner.nextLine();
                }

                if (userSelection == 1) {
                    chooseExercise(workout, exerciseList);
                } else if (userSelection == 2) {
                    workoutRun = false;
                    markComplete(workout, workoutList);
                }
            }

        }

    }

    //REQUIRES: workout, workoutList and exerciseList can't be null
    //MODIFIES: workout
    //EFFECTS: Name your workout and be sent to workout dashboard (i.e. start())
    public void createWorkout(Workout workout, WorkoutList workoutList, ExerciseList exerciseList) {
        System.out.println("Name workout: ");
        String workoutName = scanner.nextLine();
        if (workoutName.length() > 0) {
            workout.setName(workoutName);
        }
        start(workout, workoutList, exerciseList);
    }

    //REQUIRES: workout, workoutList cannot be null
    //MODIFIES: workoutList
    //EFFECTS: Given choice to add current workout to workoutList, then exits workout and go back to home dashboard
    public void markComplete(Workout workout, WorkoutList workoutList) {
        boolean validChoice = false;

        System.out.println("Type '1' to save your completed workout");
        System.out.println("Type '2' to discard your current workout");
        int userSelection;

        while (!validChoice) {
            try {
                userSelection = scanner.nextInt();
                switch (userSelection) {
                    case 1:
                        workoutList.addWorkout(workout);
                        validChoice = true;
                        break;
                    case 2:
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Please enter integer between 1-2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer (1-2)");
                scanner.nextLine();
            }

        }
        scanner.nextLine();
        System.out.println(workout.getName() + " Complete!");
    }

    // REQUIRES: workoutList can't be null
    // EFFECTS: prints the contents of workoutlist in the terminal
    public void viewWorkoutList(WorkoutList workoutList) {
        if (workoutList.size() == 0) {
            System.out.println("No Workout History.");
        } else {
            for (Workout workout : workoutList.getWorkoutList()) {
                System.out.println(workout.getName() + ": ");
                for (int i = 0; i < workout.getWorkoutExercises().size(); i++) {
                    System.out.println("- Exercise: " + workout.getWorkoutExercises().get(i).getName());
                    System.out.println("-- Sets: " + workout.getWorkoutExercises().get(i).getSets());
                    System.out.println("-- Reps: " + workout.getWorkoutExercises().get(i).getReps());
                    System.out.println("-- Weight: " + workout.getWorkoutExercises().get(i).getWeight());
                    System.out.println();

                }
            }
        }
    }

    // REQUIRES: workout and exerciseList cannot be null
    // MODIFIES: nothing
    // EFFECTS: prints the exercises in the ExerciseList, takes in user input for choosing an exercise as well as reps, sets, and weight, and runs the addExercise method
    public void chooseExercise(Workout workout, ExerciseList exerciseList) {
        ExerciseList el = new ExerciseList();
        for (Exercise exercise : exerciseList.getExerciseList()) {
            el.add(new Exercise(exercise.getName(), exercise.getSets(), exercise.getReps(), exercise.getWeight()));
        }
        boolean validInt = false;
        int num = 0, sets = 0, reps = 0, weight = 0;
        while (!validInt) {
            try {
                ExerciseManager.view(el);
                System.out.println("Please enter the number of the exercise that you wish to add: ");
                num = scanner.nextInt();
                String name = el.getExerciseList().get(num - 1).getName();
                System.out.println("You chose: " + name + ". Please enter number of sets, reps and weight you wish to add (Ex. '3 10 100'): ");
                sets = scanner.nextInt();
                reps = scanner.nextInt();
                weight = scanner.nextInt();
                scanner.nextLine();
                validInt = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                scanner.nextLine();
            }
        }
        el.getExerciseList().get(num - 1).setSets(sets);
        el.getExerciseList().get(num - 1).setReps(reps);
        el.getExerciseList().get(num - 1).setWeight(weight);
        workout.addExercise(el.getExerciseList().get(num - 1));
    }
}

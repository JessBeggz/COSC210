package model;

import UI.HomePage;

public class Main {
    public static void main(String[] args) {
        WorkoutList workoutList = new WorkoutList();
        ExerciseList exerciseList = new ExerciseList();
        HomePage.startApp(workoutList, exerciseList);
    }

}

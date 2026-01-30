package model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        Scanner scanner = new Scanner(System.in);
        boolean homePageRun = true;
        while(homePageRun) {
            System.out.println("Type '1' to begin new workout");
            int x = scanner.nextInt();
            if(x == 1) {
                Workout newWorkout;
                System.out.println("Name workout: ");
                scanner.nextLine();
                String workoutName = scanner.nextLine();
                if(workoutName.length() > 0) {
                    newWorkout = new Workout(workoutName);
                } else {
                    newWorkout = new Workout();
                }
                newWorkout.start();
        }
        }
        scanner.close();
    }  
}

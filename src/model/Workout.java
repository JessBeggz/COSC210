package model;

import java.util.Scanner;
import static model.Main.startApp;

// This class creates a new workout with a unique name
public class Workout {
    Scanner scanner = new Scanner(System.in);
    
    private String name;

    // Default Constructor
    public Workout() {
        name = "Unnamed Workout";
    }

    public Workout(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void start() {
        boolean workoutRun = true;
        while(workoutRun) {
            System.out.println("Type 1 to add exercise");
            System.out.println("Type 2 to view completed exercises");
            System.out.println("Type 3 to complete workout");
            int userSelection = scanner.nextInt();
            if(userSelection == 3) {
                workoutRun = false;
                markComplete();
            }
        }
       
    }
    public void markComplete() {
        System.out.println(this.getName() + " Complete!");
        startApp();

    }

}

package model;
import java.util.*;

// This class creates a new workout with a unique name
public class Workout {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private ArrayList<Exercise> workoutExercises;
    private ExerciseList el = new ExerciseList();

    // Default Constructor
    public Workout() {
        name = "Unnamed Workout";
        workoutExercises = new ArrayList<>();
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
    // EFFECTS: returns an int representing the size of the list
    public int size(){
        return workoutExercises.size();
    }
    // REQUIRES: e cannot be null
    // MODIFIES: workoutExercises
    // EFFECTS: checks if an exercise with the same name is already in workoutExercises. Adds to workoutExercises if there is not an exercise with the same name
    public void addExercise(Exercise e) {
        int count = 0;
            for (int i = 0; i < workoutExercises.size(); i++) {
                if (!e.getName().equals(workoutExercises.get(i).getName()))
                    count++;
                if (count==workoutExercises.size())
                    workoutExercises.add(e);
            }
    }
    // REQUIRES: el cannot be null
    // MODIFIES: nothing
    // EFFECTS: prints the exercises in the ExerciseList, takes in user input for choosing an exercise as well as reps, sets, and weight, and runs the addExercise method
    public void chooseExercise() {
        System.out.println("--------------");
    for (int i = 0; i < el.getExerciseList().size(); i++) {
            System.out.println((i+1) + ". " + el.getExerciseList().get(i).getName());
        }
        System.out.println("--------------");
        System.out.println("Please enter the number of the exercise that you wish to add: ");
        int num = scanner.nextInt();
        String name = el.getExerciseList().get(num-1).getName();
        System.out.println("You chose: " + name);
        System.out.println("Please enter the number of sets that you wish to add to " + name + ": ");
        int sets = scanner.nextInt();
        el.getExerciseList().get(num-1).setSets(sets);
        System.out.println("Please enter the number of reps that you wish to add to " + name + ": ");
        int reps = scanner.nextInt();
        el.getExerciseList().get(num-1).setReps(reps);
        System.out.println("Please enter the weight (lbs) that you wish to add to " + name + ": ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        el.getExerciseList().get(num-1).setWeight(weight);
        addExercise(el.getExerciseList().get(num-1));
        System.out.println(name + " added to workout.");
    }
    // REQUIRES: workout, workoutList, exerciseList, userExerciseList cannot be null
    // MODIFIES: workout, workoutList, exerciseList, userExerciseList
    // EFFECTS: This is the user dashboard for creating a workout
    public void start(Workout workout, WorkoutList workoutList, ExerciseList exerciseList) {
        boolean workoutRun = true;
        while(workoutRun) {
            System.out.println("Type '1' to choose an exercise");
            System.out.println("Type '2' to view completed exercises");
            System.out.println("Type '3' to complete workout");
            int userSelection = scanner.nextInt();
            if(userSelection == 1) {
                chooseExercise();
            } else if(userSelection == 3) {
                workoutRun = false;
                markComplete(workout, workoutList);
            }
        }
    
    }
    //Requires: workout, workoutList cannot be null
    //Modifies: workoutList
    //Effects: Add current workout to workoutList, exit workout and go back to home dashboard
    public void markComplete(Workout workout, WorkoutList workoutList) {
        System.out.println(workout.getName() + " Complete!");
        workoutList.addWorkout(workout);
    }

    public void createWorkout(Workout workout, WorkoutList workoutList, ExerciseList exerciseList) {
        System.out.println("Name workout: ");
        String workoutName = scanner.nextLine();
            if(workoutName.length() > 0) {
                workout.setName(workoutName);
            }
            start(workout, workoutList, exerciseList);
    }
}

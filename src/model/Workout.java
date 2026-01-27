package model;
// This class creates a new workout with a unique name
public class Workout {
    
    // Workout Variables
    private String name;

    // Default Constructor
    public Workout() {
        name = "Unnamed Workout";
    }

    // Constructor with name
    public Workout(String name) {
        this.name = name;
    }

    // Getters + Setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

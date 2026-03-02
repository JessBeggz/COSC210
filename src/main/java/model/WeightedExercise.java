package model;

import org.json.JSONObject;

// This class represents an individual exercise and stores variables for said exercise, like the name, sets, reps, and weight.
public class WeightedExercise extends Exercise{
    // private String name;
    private int sets;
    private int reps;
    private int weight;
    private final String description = "This is for exercises involving weights, reps and sets.";

    public WeightedExercise (String name) {
        super.setName(name);
        sets = 0;
        reps = 0;
        weight = 0;
    }
    public WeightedExercise (String name, int sets, int reps, int weight) {
        super.setName(name);
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }

    public int getSets() {
        return sets;
    }
    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }
    public void setReps (int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    //REQUIRES: this can't be null
    //EFFECTS: returns json object representing this exercise
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("name", this.getName());
        obj.put("sets", this.getSets());
        obj.put("reps", this.getReps());
        obj.put("weight", this.getWeight());
        return obj;
    }
    @Override
    public String getDescription() {
        return description;
    }
   
}
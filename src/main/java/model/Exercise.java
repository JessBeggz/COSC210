package model;

import org.json.JSONObject;

public abstract class Exercise {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public abstract JSONObject toJson();

     public int getSets() {
        return 0;
    }
    public void setSets(int sets) {
    }

    public int getReps() {
        return 0;
    }
    public void setReps (int reps) {
    }

    public int getWeight() {
        return 0;
    }
    public void setWeight(int weight) {
    }

     public double getTime() {
        return 0;
    }
    
    public void setTime(long t) {
    }
    
    public double getDistance() {
        return 0;
    }
    
    public void setDistance(double d) {
    }
    
}

package model;

import org.json.JSONObject;

// This class represents a cardio exercise and stores variables for said cardio exercise, like the time and distance
public class CardioExercise extends Exercise {
    private double distance;
    private double cardioTime;
    private final String description = "This is for cardio exercises involving distance and time";

    public CardioExercise(String name, double distance, double cardioTime) {
        super.setName(name);
        this.distance = distance;
        this.cardioTime = cardioTime;
    }

    @Override
    public double getTime() {
        return cardioTime;
    }
    
    @Override
    public void setTime(long t) {
        this.cardioTime = t;
    }
    
    @Override
    public double getDistance() {
        return distance;
    }
    
    @Override
    public void setDistance(double d) {
        this.distance = d;
    }

    //REQUIRES: this can't be null
    //EFFECTS: returns json object representing this cardio exercise
    @Override
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("name", this.getName());
        obj.put("time", this.getTime());
        obj.put("distance", this.getDistance());
        return obj;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

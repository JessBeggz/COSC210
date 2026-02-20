package persistence;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import model.ExerciseList;
import model.WorkoutList;

//Represents a writer that writes JSON representation of ExerciseList and WorkoutList to file
public class JsonWriter {

    private String dest;
    private FileWriter file;

    //EFFECTS: constructs writer to write to destination file
    public JsonWriter(String dest) {
        this.dest = dest;
    }
    //MODIFIES: this
    //EFFECTS: opens writer
    public void open() {
        try {
            file = new FileWriter(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //REQUIRES: exerciseList can't be null
    //MODIFIES: file
    //EFFECTS: writes exerciseList json data to json destination file
    public void write(ExerciseList exerciseList) {
        JSONObject obj = exerciseList.toJson();
        try {
            file.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //REQUIRES: workoutList can't be null
    //MODIFIES: file
    //EFFECTS: writes workoutList json data to json destination file
    public void write(WorkoutList workoutList) {
        JSONObject obj = workoutList.toJson();
        try {
            file.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //REQUIRES:
    //MODIFIES: file
    //EFFECTS: closes destination file
    public void closeWriter() {
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

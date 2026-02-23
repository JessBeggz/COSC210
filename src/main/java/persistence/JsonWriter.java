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
    public void open() throws IOException {
        file = new FileWriter(dest);

    }

    //REQUIRES: exerciseList can't be null
    //MODIFIES: file
    //EFFECTS: writes exerciseList json data to json destination file
    public void write(ExerciseList exerciseList) throws IOException {
        JSONObject obj = exerciseList.toJson();
        file.write(obj.toString());

    }

    //REQUIRES: workoutList can't be null
    //MODIFIES: file
    //EFFECTS: writes workoutList json data to json destination file
    public void write(WorkoutList workoutList) throws IOException {
        JSONObject obj = workoutList.toJson();
        file.write(obj.toString());
    }

    //REQUIRES:
    //MODIFIES: file
    //EFFECTS: closes destination file
    public void closeWriter() throws IOException {
        file.close();
    }

}

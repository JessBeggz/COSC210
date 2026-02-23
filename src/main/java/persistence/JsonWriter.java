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

    //REQUIRES: dest cannot be null
    //MODIFEIS: this
    //EFFECTS: constructs JsonWriter with destination set to dest
    public JsonWriter(String dest) {
        this.dest = dest;
    }

    //REQUIRES: dest file path is valid
    //MODIFIES: this
    //EFFECTS: opens writer
    public void open() throws IOException {
        file = new FileWriter(dest);

    }

    //REQUIRES: exerciseList can't be null and file is open
    //MODIFIES: this
    //EFFECTS: writes exerciseList json data to json destination file
    public void write(ExerciseList exerciseList) throws IOException {
        JSONObject obj = exerciseList.toJson();
        file.write(obj.toString());

    }

    //REQUIRES: workoutList can't be null and file is open
    //MODIFIES: this
    //EFFECTS: writes workoutList json data to json destination file
    public void write(WorkoutList workoutList) throws IOException {
        JSONObject obj = workoutList.toJson();
        file.write(obj.toString());
    }

    //REQUIRES: file is open
    //MODIFIES: this
    //EFFECTS: closes destination file
    public void closeWriter() throws IOException {
        file.close();
    }

}

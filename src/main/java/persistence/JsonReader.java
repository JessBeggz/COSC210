//Reused and modified from Demo Phase2 Application - JsonReader class
package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Exercise;
import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private final String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source != null ? source : "";
    }

    // EFFECTS: reads ExerciseList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ExerciseList readExerciseList() throws IOException {
        if (source.isEmpty()) {
            throw new IOException("Source path is empty");
        }
        try {
            String jsonData = readFile(source);
            if (jsonData == null || jsonData.trim().isEmpty()) {
                throw new IOException("File is empty or could not be read");
            }
            JSONObject jsonObject = new JSONObject(jsonData);
            return parseExerciseList(jsonObject);
        } catch (org.json.JSONException e) {
            throw new IOException("Invalid JSON in file: " + source, e);
        }
    }
    // EFFECTS: reads WorkoutList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutList readWorkoutList() throws IOException {
        if (source.isEmpty()) {
            throw new IOException("Source path is empty");
        }
        try {
            String jsonData = readFile(source);
            if (jsonData == null || jsonData.trim().isEmpty()) {
                throw new IOException("File is empty or could not be read");
            }
            JSONObject jsonObject = new JSONObject(jsonData);
            return parseWorkoutList(jsonObject);
        } catch (org.json.JSONException e) {
            throw new IOException("Invalid JSON in file: " + source, e);
        }
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Path path = Paths.get(source);
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + source);
        }
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses ExericseList from JSON object, then adds Exercises to ExerciseList
    private ExerciseList parseExerciseList(JSONObject jsonObject) throws org.json.JSONException {
        ExerciseList el = new ExerciseList();

        JSONArray exerciseListArray = jsonObject.getJSONArray("exerciseList");
        for (int i = 0; i < exerciseListArray.length(); i++) {
            JSONObject exerciseJson = exerciseListArray.getJSONObject(i);

                Exercise e = new Exercise(exerciseJson.getString("name"), exerciseJson.getInt("reps"), exerciseJson.getInt("sets"), exerciseJson.getInt("weight"));
                el.add(e);
        }
        return el;
    }
    // EFFECTS: parses WorkoutList from JSON object, then adds Exercises to Workout, and adds Workout to WorkoutList
    private WorkoutList parseWorkoutList(JSONObject jsonObject) throws org.json.JSONException {
        WorkoutList wl = new WorkoutList();

        JSONArray workoutListArray = jsonObject.getJSONArray("WorkoutList");
        for (int i = 0; i < workoutListArray.length(); i++) {
            JSONObject workoutJson = workoutListArray.getJSONObject(i);
            String name = workoutJson.getString("workoutTitle");
            Workout w = new Workout(name);

            JSONArray exercisesArray = workoutJson.getJSONArray("WorkoutExercises");
            for (int j = 0; j < exercisesArray.length(); j++) {
                JSONObject exerciseJson = exercisesArray.getJSONObject(j);

                Exercise e = new Exercise(exerciseJson.getString("name"), exerciseJson.getInt("reps"), exerciseJson.getInt("sets"), exerciseJson.getInt("weight"));
                w.addExercise(e);
            }
            wl.addWorkout(w);
        }
        return wl;
    }

    // // MODIFIES: wr
    // // EFFECTS: parses thingies from JSON object and adds them to workroom
    // private void addThingies(Workroom wr, JSONObject jsonObject) throws org.json.JSONException {
    //     JSONArray jsonArray = jsonObject.getJSONArray("thingies");
    //     for (int i = 0; i < jsonArray.length(); i++) {
    //         Object item = jsonArray.get(i);
    //         if (item instanceof JSONObject) {
    //             addThingy(wr, (JSONObject) item);
    //         }
    //     }
    // }

    // // MODIFIES: wr
    // // EFFECTS: parses thingy from JSON object and adds it to workroom
    // private void addThingy(Workroom wr, JSONObject jsonObject) throws org.json.JSONException {
    //     String name = jsonObject.has("name") ? jsonObject.getString("name") : "";
    //     String categoryStr = jsonObject.has("category") ? jsonObject.getString("category") : "STITCHING";
    //     Category category;
    //     try {
    //         category = Category.valueOf(categoryStr);
    //     } catch (IllegalArgumentException e) {
    //         category = Category.STITCHING;
    //     }
    //     wr.addThingy(new Thingy(name, category));
    // }
}
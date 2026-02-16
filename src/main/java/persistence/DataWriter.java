package persistence;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Exercise;
import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

public class DataWriter {
    
    //REQUIRES: workoutList can't be null
    //MODIFES: workoutListData.json
    //EFFECTS: Converts and saves workoutlist to json
    public void save(WorkoutList workoutList) {
        JSONObject root = new JSONObject();
        JSONArray saveArray = new JSONArray();
        FileWriter file;
        for (int j = 0; j < workoutList.getWorkoutList().size(); j++) {
            Workout workout = workoutList.getWorkoutList().get(j);
            JSONObject exercises = new JSONObject();
            JSONArray exercisesArray = new JSONArray();
            for (int i = 0; i < workout.getWorkoutExercises().size(); i++) {
                JSONObject workouts = new JSONObject();
                workouts.put("name", workout.getWorkoutExercises().get(i).getName());
                workouts.put("reps", workout.getWorkoutExercises().get(i).getReps());
                workouts.put("sets", workout.getWorkoutExercises().get(i).getSets());
                workouts.put("weight", workout.getWorkoutExercises().get(i).getWeight());
                exercisesArray.put(workouts);
            }
            exercises.put("title", workout.getName());
            exercises.put("exercises", exercisesArray);
            saveArray.put(exercises);
        }
        root.put("workoutList", saveArray);
        try {
            System.out.println(root.toString(2)); //FOR EXAMPLE AFTER LOAD COMPLETE
            file = new FileWriter("./data/workoutListData.json");
            file.write(root.toString());
            file.close();
            System.out.println("Saved WorkoutList!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        //REQUIRES: exerciseList can't be null
        //MODIFES: exerciseListData.json
        //EFFECTS: Converts and saves exerciseList to json
        public void save(ExerciseList exerciseList) {
        JSONObject root = new JSONObject();
        JSONArray saveArray = new JSONArray();
        FileWriter file;
        for (int j = 0; j < exerciseList.getExerciseList().size(); j++) {
            Exercise exercise = exerciseList.getExerciseList().get(j);
            JSONObject exerciseName = new JSONObject();
            exerciseName.put("name", exercise.getName());
            saveArray.put(exerciseName);
        }
        root.put("exerciseList", saveArray);
        try {
            System.out.println(root.toString(2)); // FOR EXAMPLE AFTER LOAD COMPLETE
            file = new FileWriter("./data/exerciseListData.json");
            file.write(root.toString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}

}

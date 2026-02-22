package tests;

import java.io.File;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Exercise;
import model.ExerciseList;
import model.Workout;
import model.WorkoutList;
import persistence.JsonWriter;

public class JsonWriterTest {

    ExerciseList el;
    WorkoutList wl;
    Workout w;
    JsonWriter exerciseWriter;
    JsonWriter workoutWriter;


    @BeforeEach
    public void setUp() {
        el = new ExerciseList();
        wl = new WorkoutList();
        w = new Workout();
        exerciseWriter = new JsonWriter("./data/exerciseListData.json");
        workoutWriter = new JsonWriter("./data/workoutListData.json");
        
    }

    @Test
    public void testWorkoutList() {
        w.addExercise(new Exercise("Jumping Jacks"));
        wl.addWorkout(w);
        workoutWriter.open();
        workoutWriter.write(wl);
        workoutWriter.closeWriter();

        File workoutFile = new File("./data/workoutListData.json");
        assertTrue(workoutFile.exists());
    }

    @Test
    public void testExerciseList() {
        el.add(new Exercise("Jumping Jacks"));
        exerciseWriter.open();
        exerciseWriter.write(el);
        exerciseWriter.closeWriter();

        File exerciseFile = new File("./data/exerciseListData.json");
        assertTrue(exerciseFile.exists());
    }
}

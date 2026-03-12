package model;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.exceptions.DuplicateExerciseException;
import persistence.JsonReader;
import persistence.JsonWriter;

public class JsonWriterTest {

    ExerciseList el;
    WorkoutList wl;
    Workout w;
    WeightedExercise e;
    CardioExercise c;


    @BeforeEach
    public void setUp() {
        el = new ExerciseList();
        wl = new WorkoutList();
        w = new Workout("Upper");
        e = new WeightedExercise("Jumping Jacks");
        c = new CardioExercise("Skipping",0,0);
    }

    @Test
    public void testEmptyWorkoutList() {
        try {
            JsonWriter workoutWriter = new JsonWriter("./src/test/java/tests/data/workoutListDataTest.json");
            workoutWriter.open();
            workoutWriter.write(wl);
            workoutWriter.closeWriter();
            
            JsonReader workoutListReader = new JsonReader("./src/test/java/tests/data/workoutListDataTest.json");
            wl = workoutListReader.readWorkoutList();

            assertEquals(0, wl.getWorkoutList().size());
        } catch (IOException ex) {
            System.out.println("Error occurred!");
            ex.printStackTrace();
        }
    }

    @Test
    public void testWorkoutList() {
        try {
            w.addExercise(e);
            w.addExercise(c);
            wl.getWorkoutList().add(w);

            JsonWriter workoutWriter = new JsonWriter("./src/test/java/tests/data/workoutListWriteDataTest.json");
            workoutWriter.open();
            workoutWriter.write(wl);
            workoutWriter.closeWriter();
            
            JsonReader workoutListReader = new JsonReader("./src/test/java/tests/data/workoutListWriteDataTest.json");
            wl = workoutListReader.readWorkoutList();

            assertEquals(1, wl.getWorkoutList().size());
            assertEquals("Upper", wl.getWorkoutList().get(0).getName());
            assertEquals("Jumping Jacks", wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getName());
            assertEquals("Skipping", wl.getWorkoutList().get(0).getWorkoutExercises().get(1).getName());
            assertEquals(0, wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getSets());
            assertEquals(0, wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getReps());
            assertEquals(0, wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getWeight());
            assertEquals(0, wl.getWorkoutList().get(0).getWorkoutExercises().get(1).getTime());
            assertEquals(0, wl.getWorkoutList().get(0).getWorkoutExercises().get(1).getDistance());
        } catch (IOException ex) {
            System.out.println("Error occurred!");
            ex.printStackTrace();
        }
    }

    @Test
    public void testExerciseList() throws DuplicateExerciseException {
        try {
            el.add(e);
            
            JsonWriter exerciseWriter = new JsonWriter("./src/test/java/tests/data/exerciseListWriteDataTest.json");
            exerciseWriter.open();
            exerciseWriter.write(el);
            exerciseWriter.closeWriter();
            
            JsonReader exerciseListReader = new JsonReader("./src/test/java/tests/data/exerciseListWriteDataTest.json");
            el = exerciseListReader.readExerciseList();

            assertEquals(8, el.getExerciseList().size());
            assertEquals("Jumping Jacks", el.getExerciseList().get(7).getName());
            assertEquals(0, el.getExerciseList().get(7).getSets());
            assertEquals(0, el.getExerciseList().get(7).getReps());
            assertEquals(0, el.getExerciseList().get(7).getWeight());
        } catch (IOException ex) {
            System.out.println("Error occurred!");
            ex.printStackTrace();
        }
    }
}

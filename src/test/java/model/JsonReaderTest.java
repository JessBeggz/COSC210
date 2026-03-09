package model;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import persistence.JsonReader;

public class JsonReaderTest {

    @Test
    public void emptyTest() {
        JsonReader reader = new JsonReader("");

        assertThrows(IOException.class, reader::readWorkoutList);
        assertThrows(IOException.class, reader::readExerciseList);
    }

    @Test
    public void workoutListDataTest() {
        try {
            JsonReader workoutListReader = new JsonReader("./src/test/java/tests/data/workoutListReadDataTest.json"); //contains 1 saved workout with 1 exercise object
            WorkoutList wl = workoutListReader.readWorkoutList();
            
            assertEquals(1, wl.size());
            assertEquals("workout1", wl.getWorkoutList().get(0).getName());
            assertEquals("Hip Thrust", wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getName());
            assertEquals(22, wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getSets());
            assertEquals(22, wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getReps());
            assertEquals(22, wl.getWorkoutList().get(0).getWorkoutExercises().get(0).getWeight());

        } catch (IOException ex) {
            System.out.println("Error occurred!");
            ex.printStackTrace();
        }
    }

    @Test
    public void exerciseListDataTest() {
        try {
            JsonReader exerciseListReader = new JsonReader("./src/test/java/tests/data/exerciseListReadDataTest.json"); //contains default ExerciseList, which has 7 exercise objects
            ExerciseList el = exerciseListReader.readExerciseList();
            
            assertEquals(7, el.size());
            assertEquals("Squat", el.getExerciseList().get(0).getName());
            assertEquals(0, el.getExerciseList().get(0).getSets());
            assertEquals(0, el.getExerciseList().get(0).getReps());
            assertEquals(0, el.getExerciseList().get(0).getWeight());
        } catch (IOException ex) {
            System.out.println("Error occurred!");
            ex.printStackTrace();
        }
    }
}

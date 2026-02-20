package tests;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import model.ExerciseList;
import model.WorkoutList;
import persistence.JsonReader;

public class JsonReaderTest {

    @Test
    public void emptyTest() throws IOException {
        JsonReader reader = new JsonReader("");

        assertThrows(IOException.class, reader::readWorkoutList);
        assertThrows(IOException.class, reader::readExerciseList);
    }

    @Test
    public void workoutListDataTest() throws IOException {
        JsonReader workoutListReader = new JsonReader("./src/test/java/tests/data/workoutListDataTest.json"); //contains 1 saved workout with 1 exercise object
        WorkoutList wl = workoutListReader.readWorkoutList();
        
        assertEquals(1, wl.size());
    }

    @Test
    public void exerciseListDataTest() throws IOException {
        JsonReader exerciseListReader = new JsonReader("./src/test/java/tests/data/exerciseListDataTest.json"); //contains default ExerciseList, which has 7 exercise objects
        ExerciseList el = exerciseListReader.readExerciseList();
        
        assertEquals(7, el.size());
    }
}

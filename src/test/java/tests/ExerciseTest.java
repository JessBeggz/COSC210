package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.WeightedExercise;

public class ExerciseTest {

    @Test
    public void testDefaultConstructor() {
        WeightedExercise d = new WeightedExercise("Plank");

        assertEquals("Plank", d.getName());
        assertEquals(0, d.getReps());
        assertEquals(0, d.getSets());
        assertEquals(0, d.getWeight());
    }
    @Test
    public void testCustomConstructor() {
        WeightedExercise c = new WeightedExercise("Plank", 3, 12, 5);

        assertEquals("Plank", c.getName());
        assertEquals(3, c.getSets());
        assertEquals(12, c.getReps());
        assertEquals(5, c.getWeight());
    }
    @Test
    public void testSetters() {
        WeightedExercise blank = new WeightedExercise("");

        blank.setName("Push up");
        assertEquals("Push up", blank.getName());

        blank.setSets(3);
        assertEquals(3, blank.getSets());

        blank.setReps(10);
        assertEquals(10, blank.getReps());

        blank.setWeight(45);
        assertEquals(45, blank.getWeight());
    }

    @Test
    public void testGetDescription() {
        WeightedExercise w = new WeightedExercise("Plank");
        assertTrue(w.getDescription().length() > 0);
        assertEquals("This is for exercises involving weights, reps and sets.", w.getDescription());
    }
}

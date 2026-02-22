package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.Exercise;

public class ExerciseTest {

    @Test
    public void testDefaultConstructor() {
        Exercise d = new Exercise("Plank");

        assertEquals("Plank", d.getName());
        assertEquals(0, d.getReps());
        assertEquals(0, d.getSets());
        assertEquals(0, d.getWeight());
    }
    @Test
    public void testCustomConstructor() {
        Exercise c = new Exercise("Plank", 3, 12, 5);

        assertEquals("Plank", c.getName());
        assertEquals(3, c.getSets());
        assertEquals(12, c.getReps());
        assertEquals(5, c.getWeight());
    }
    @Test
    public void testSetters() {
        Exercise blank = new Exercise("");

        blank.setName("Push up");
        assertEquals("Push up", blank.getName());

        blank.setSets(3);
        assertEquals(3, blank.getSets());

        blank.setReps(10);
        assertEquals(10, blank.getReps());

        blank.setWeight(45);
        assertEquals(45, blank.getWeight());
    }
}

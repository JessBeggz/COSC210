package model;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CardioExerciseTest {

    @Test
    public void testConstructor() {
        CardioExercise c = new CardioExercise("Run", 5, 30);

        assertEquals("Run", c.getName());
        assertEquals(5, c.getDistance());
        assertEquals(30, c.getTime());
    }
    @Test
    public void testSettersAndGetters() {
        CardioExercise c = new CardioExercise("Run", 5, 30);

        c.setTime(40);
        assertEquals(40, c.getTime());

        c.setDistance(10);
        assertEquals(10, c.getDistance());
    }

    @Test
    public void testGetDescription() {
        CardioExercise c = new CardioExercise("Run", 5, 30);
        assertTrue(c.getDescription().length() > 0);
        assertEquals("This is for cardio exercises involving distance and time", c.getDescription());
    }
}

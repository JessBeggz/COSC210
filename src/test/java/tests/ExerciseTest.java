package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Exercise;

public class ExerciseTest {

    Exercise exercise1;
    Exercise exercise2;

    @BeforeEach
    public void setUp() {
        exercise1 = new Exercise("Bench Press");
        exercise2 = new Exercise("Squat");
    }

    @Test
    public void testName() {
        exercise1.setName("Squat");
        assertEquals(exercise1.getName(), exercise2.getName());
    }
}

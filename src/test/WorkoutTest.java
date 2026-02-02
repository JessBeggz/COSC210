package test;
import model.Exercise;
import model.Workout;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class WorkoutTest {
    Workout w = new Workout();;
    Exercise a = new Exercise("Squat");

    @Test
    public void testAddExercise() {
        assertEquals(0, w.size());
        w.addExercise(a);
        assertEquals(1, w.size());
        w.addExercise(a);
        assertEquals(1, w.size());
    }
}
